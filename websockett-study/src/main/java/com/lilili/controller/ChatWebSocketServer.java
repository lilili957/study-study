package com.lilili.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lilili.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author LiYuan
 * @Date 2022/1/6
 **/
@Component
@ServerEndpoint(value = "/chat/{username}")
@Slf4j
public class ChatWebSocketServer {

    private static AtomicInteger onlineCount = new AtomicInteger();
    private static ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<>(20);

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        if (!StringUtils.hasText(username)) {
            throw new IllegalArgumentException("username不能为空");
        }
        sessionMap.put("username", session);
        int count = onlineCount.incrementAndGet();
        log.info("[{}]登陆了， 当前在线人数{}", username, count);

    }

    @OnClose
    public void onClose(Session session, @PathParam("username") String username) {
        sessionMap.remove(username);
        int count = onlineCount.decrementAndGet();
        log.info("[{}]退出了，当前在线人数{}", username, count);
    }

    @OnMessage
    public void onMessage(Session session, String receiveMessage) {
        log.info("收到来自客户端的消息，{}", receiveMessage);
        Message message = JSONObject.parseObject(receiveMessage, new TypeReference<Message>() {
        });
        sendMessage(message);
    }

    public static void sendMessage(String username, String message) {
        Session session = sessionMap.get(username);
        if (session != null) {
            sendMessage(session, message);
        } else {
            log.warn("[{}]未登录", username);
        }
    }

    private static void sendMessage(Message message) {
        log.info("[message] - : {}", message);
        String target = message.getTarget();
        String from = message.getFrom();
        String msg = message.getMessage();
        //三者都存在的情况下发送信息
        if (!StringUtils.hasText(target) || !StringUtils.hasText(from) || !StringUtils.hasText(msg)) {
            log.info("target、from或msg为空， 不发送信息");
            return;
        }
        Session fromSession = sessionMap.get(from);
        Session toSession = sessionMap.get(target);

        //发送人未登录
        if (fromSession == null) {
            log.warn("from {} 未登录", from);
            return;
        }
        //接收人未登录
        if (toSession == null) {
            log.warn("target {} 未登录", target);
            return;
        }

        try {
            toSession.getBasicRemote().sendText(JSONObject.toJSONString(message));
        } catch (IOException e) {
            log.warn("消息未发送: {}", e.getMessage());
            e.printStackTrace();
        }
    }

//    private static void sendMessage(String from, Session toSession, String msg) {
//        try {
//            toSession.getBasicRemote().send()
//        }
//    }

    public static void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            log.warn("发送信息失败: {}", e.getMessage());
            e.printStackTrace();
        }
    }
}
