package com.lilili.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author LiYuan
 * @Date 2022/1/5
 **/
@ServerEndpoint("/ws/asset")
@Component
@Slf4j
public class WebSocketServer {

    @PostConstruct
    public void init() {
        log.info("WebSocketServer加载");
    }

    private static AtomicInteger onlineCount = new AtomicInteger();

    private static CopyOnWriteArraySet<Session> sessionSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void open(Session session) {
        sessionSet.add(session);
        int cnt = onlineCount.incrementAndGet();
        log.info("有新连接加入, 当前连接数为: {}, 加入连接sessionId: {}", cnt, session.getId());
        sendMessage(session, "连接成功");
    }

    @OnClose
    public void close(Session session) {
        sessionSet.remove(session);
        int dnt = onlineCount.decrementAndGet();
        log.info("有连接退出，当前连接数为: {}", dnt);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("收到来自客户端的消息: {}", message);
        sendMessage(session, "收到消息，消息内容: " + message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误：{}，Session ID： {}", error.getMessage(), session.getId());
        error.printStackTrace();
    }

    public static void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.warn("发送消息出错: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    public static void broadCastInfo(String message) throws IOException {
        sessionSet.forEach(session -> {
            if (session.isOpen()) {
                sendMessage(session, message);
            }
        });
    }

    public static void sendMessage(String sessionId, String message) {
        Session session = null;
        for (Session s: sessionSet) {
            if (s.getId().equals(sessionId)) {
                session = s;
                break;
            }
        }
        if (session != null) {
            sendMessage(session, message);
        } else {
            log.warn("没有id为:{}的会话", session);
        }
    }
}
