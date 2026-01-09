package com.example.scheduleproject2.user.dto;

import lombok.Getter;

@Getter
public class SigninUserResponse {

    private final Long userId;
    private final String name;
    private final String email;

    public SigninUserResponse(Long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
}
