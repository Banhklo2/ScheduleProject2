package com.example.scheduleproject2.user.dto;

import lombok.Getter;

@Getter
public class SessionUser {

    private final Long userId;
    private final String email;
    private final String name;

    public SessionUser(Long userId, String email, String name) {
        this.userId = userId;
        this.email = email;
        this.name = name;
    }
}
