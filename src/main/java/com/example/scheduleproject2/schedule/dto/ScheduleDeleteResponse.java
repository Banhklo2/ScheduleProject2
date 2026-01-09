package com.example.scheduleproject2.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleDeleteResponse {

    private final Long id;
    private final String message;

    public ScheduleDeleteResponse(Long id, String message) {
        this.id = id;
        this.message = message;
    }
}
