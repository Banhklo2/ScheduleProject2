package com.example.scheduleproject2.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleCreateRequest {

    private Long userId;
    private String title;
    private String content;
}
