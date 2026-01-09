package com.example.scheduleproject2.schedule.controller;

import com.example.scheduleproject2.schedule.dto.*;
import com.example.scheduleproject2.schedule.service.ScheduleService;
import com.example.scheduleproject2.user.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleCreateResponse> create(
            @SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser,
            @RequestBody ScheduleCreateRequest request
    ) {
       return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.save(sessionUser, request));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleGetResponse>> getAll(
            @SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findAll());
    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleGetResponse> getOne(
            @SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser,
            @PathVariable Long scheduleId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.findOne(scheduleId));
    }

    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleUpdateResponse> update(
            @SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser,
            @PathVariable Long scheduleId,
            @RequestBody ScheduleUpdateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.update(sessionUser, scheduleId, request));
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public void delete(
            @SessionAttribute(name = "loginUser", required = false) SessionUser sessionUser,
            @PathVariable Long scheduleId
    ) {
        scheduleService.delete(sessionUser, scheduleId);
    }
}
