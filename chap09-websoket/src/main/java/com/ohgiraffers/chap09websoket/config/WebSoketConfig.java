package com.ohgiraffers.chap09websoket.config;

import com.ohgiraffers.chap09websoket.server.ChatWebSoketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSoketConfig implements WebSocketConfigurer {


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // WebSocket 핸들러 등록하는 메소드
        registry.addHandler(new ChatWebSoketHandler(),
                "/chattingServer").setAllowedOrigins("*");
    }
}
