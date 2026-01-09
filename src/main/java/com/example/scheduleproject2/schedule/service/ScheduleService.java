package com.example.scheduleproject2.schedule.service;

import com.example.scheduleproject2.schedule.dto.*;
import com.example.scheduleproject2.schedule.entity.Schedule;
import com.example.scheduleproject2.schedule.repository.ScheduleRepository;
import com.example.scheduleproject2.user.dto.SessionUser;
import com.example.scheduleproject2.user.entity.User;
import com.example.scheduleproject2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    // 일정 생성
    @Transactional
    public ScheduleCreateResponse save(SessionUser sessionUser, ScheduleCreateRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(
                () -> new IllegalStateException("존재하지 않는 사용자입니다.")
        );

        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                user
        );

        Schedule saved = scheduleRepository.save(schedule);

        return new ScheduleCreateResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getContent(),
                saved.getUser().getId(),
                saved.getUser().getName(),
                saved.getCreatedAt(),
                saved.getModifiedAt()
        );
    }

    // 전체 일정 조회
    @Transactional(readOnly = true)
    public List<ScheduleGetResponse> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleGetResponse> dtos = new ArrayList<>();

        for (Schedule schedule : schedules) {
            ScheduleGetResponse dto = new ScheduleGetResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getUser().getId(),
                    schedule.getUser().getName(),
                    schedule.getCreatedAt(),
                    schedule.getModifiedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    // 단건 일정 조회
    @Transactional(readOnly = true)
    public ScheduleGetResponse findOne(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        return new ScheduleGetResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getUser().getId(),
                schedule.getUser().getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    // 일정 수정
    @Transactional
    public ScheduleUpdateResponse update(SessionUser sessionUser, Long scheduleId, ScheduleUpdateRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("없는 일정입니다.")
        );

        schedule.update(
                request.getTitle(),
                request.getContent()
        );

        return new ScheduleUpdateResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getUser().getId(),
                schedule.getUser().getName(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    // 일정 삭제
    @Transactional
    public void delete(SessionUser sessionUser, Long scheduleId) {
        boolean existence = scheduleRepository.existsById(scheduleId);

        // 존재하지 않으면
        if (!existence) {
            throw new IllegalStateException("없는 일정입니다.");
        }

        // 존재하면
        scheduleRepository.deleteById(scheduleId);
    }
}
