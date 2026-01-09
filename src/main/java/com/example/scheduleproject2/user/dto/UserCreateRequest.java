package com.example.scheduleproject2.user.dto;

import lombok.Getter;

@Getter
public class UserCreateRequest {

    private String name;
    private String email;
    private String password;
}
