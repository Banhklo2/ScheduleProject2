package com.example.scheduleproject2.user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SignupUserResponse {

    private final Long userId;
    private final String name;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public SignupUserResponse(Long userId, String name, String email, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
