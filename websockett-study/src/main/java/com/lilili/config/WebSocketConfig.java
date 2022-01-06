package com.lilili.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Author LiYuan
 * @Date 2022/1/5
 **/
@Configuration
public class WebSocketConfig {

    /**
     * 检测所有@ServerEndpoint注解的类， 注册到容器中
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
