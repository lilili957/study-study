package com.lilili.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Author LiYuan
 * @Date 2022/1/5
 **/
@Slf4j
@RestController
@RequestMapping(value = "/api/ws")
public class WebSocketController {

    @PostMapping("/sendOne")
    public void sendOne(String sessionId, String message) {
        log.info("要发送的消息: sessionId: {}, message: {}", sessionId, message);
        WebSocketServer.sendMessage(sessionId, message);
    }

    @PostMapping("/sendAll")
    public void sendAll(String message) throws IOException {
        log.info("要群发的信息: {}", message);
        WebSocketServer.broadCastInfo(message);
    }
}
