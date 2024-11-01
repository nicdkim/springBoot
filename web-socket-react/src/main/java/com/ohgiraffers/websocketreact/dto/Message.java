package com.ohgiraffers.websocketreact.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class Message {

    private String type;
    private String userId;
    private String message;
    private LocalDateTime timestamp;

    public Message() {
    }

    public Message(String type, String userId, String message, Date currentDate) {
        this.type = type;
        this.userId = userId;
        this.message = message;
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type='" + type + '\'' +
                ", userId='" + userId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
