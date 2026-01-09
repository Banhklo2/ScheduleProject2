package com.example.scheduleproject2.user.service;

import com.example.scheduleproject2.user.dto.*;
import com.example.scheduleproject2.user.dto.UserCreateRequest;
import com.example.scheduleproject2.user.dto.UserCreateResponse;
import com.example.scheduleproject2.user.dto.UserGetResponse;
import com.example.scheduleproject2.user.entity.User;
import com.example.scheduleproject2.user.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 유저 생성
    @Transactional
    public UserCreateResponse save(UserCreateRequest request) {
        User user = new User(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );

        User saved = userRepository.save(user);

        return new UserCreateResponse(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getCreatedAt(),
                saved.getModifiedAt()
        );
    }

    // 전체 유저 조회
    @Transactional(readOnly = true)
    public List<UserGetResponse> findAll() {
        List<User> users = userRepository.findAll();
        List<UserGetResponse> dtos = new ArrayList<>();
        for (User user : users) {
            UserGetResponse response = new UserGetResponse(
                    user.getId(),
                    user.getName(),
                    user.getEmail(),
                    user.getCreatedAt(),
                    user.getModifiedAt()
            );
            dtos.add(response);
        }
        return dtos;
    }

    // 단건 유저 조회
    @Transactional(readOnly = true)
    public UserGetResponse findOne(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );
        return new UserGetResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    // 유저 수정
    @Transactional
    public UserUpdateResponse update(Long userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("없는 유저입니다.")
        );
        user.update(
                request.getName(),
                request.getEmail()
        );
        return new UserUpdateResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    // 유저 삭제
    @Transactional
    public void delete(Long userId) {
        boolean existence = userRepository.existsById(userId);

        // 존재하지 않으면
        if (!existence) {
            throw new IllegalStateException("없는 유저입니다.");
        }

        // 존재하면
        userRepository.deleteById(userId);
    }

    @Transactional
    public SignupUserResponse save(SignupUserRequest request) {
        User user = new User(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );
        User savedUser = userRepository.save(user);
        return new SignupUserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getCreatedAt(),
                savedUser.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public SigninUserResponse signin(@Valid SigninUserRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new IllegalStateException("유효하지 않은 이메일입니다.")
        );
        // 비밀번호가 같지 않으면
        if (!ObjectUtils.nullSafeEquals(user.getPassword(), request.getPassword())) {
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }
        // 비밀번호가 같으면
        return new SigninUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
