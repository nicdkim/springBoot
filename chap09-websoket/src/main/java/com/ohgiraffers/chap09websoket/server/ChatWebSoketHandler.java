package com.ohgiraffers.chap09websoket.server;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ChatWebSoketHandler extends TextWebSocketHandler {

    // 접속한 클라이언트의 webSocketSession 을 관리할 set
    private static Set<WebSocketSession> clients = Collections.synchronizedSet(new HashSet<>());

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // 클라이언트가 WebSocket 연결을 성공적으로 수행했을 때 호출되는 메소드
        clients.add(session);
        System.out.println("웹소켓 연결 : " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 클라이언트로부터 텍스트 메세지를 수신했을 때 호출되는 메소드
        System.out.println("메세지 출력 : " + session.getId() + " : " + message.getPayload());
        synchronized (clients) {
            for (WebSocketSession client : clients) {
                if (!client.equals(session)) {
                    // 메세지를 자기 자신을 제외하고 전송
                    client.sendMessage(new TextMessage(message.getPayload()));
                }
            }
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // 통신 중 에러가 발생했을 때 호출되는 메소드
        System.out.println("에러 발생 : " + session.getId());
        exception.printStackTrace();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 클라이언트가 WebSocket 연결을 닫았을 때 호출되는 메소드
        clients.remove(session);
        System.out.println("웹소켓 종료 : " + session.getId());
    }
}
