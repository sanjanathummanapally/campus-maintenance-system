package com.campus.maintenance.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campus.maintenance.dto.RegisterRequest;
import com.campus.maintenance.dto.UserResponse;
import com.campus.maintenance.entity.Role;
import com.campus.maintenance.entity.User;
import com.campus.maintenance.exception.DuplicateEmailException;
import com.campus.maintenance.repository.UserRepository;
import com.campus.maintenance.service.AuthService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponse register(RegisterRequest request) {
        String email = request.getEmail().trim().toLowerCase();

        if (userRepository.existsByEmail(email)) {
            throw new DuplicateEmailException(email);
        }

        User user = User.builder()
                .name(request.getName())
                .email(email)
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .department(request.getDepartment())
                .role(Role.STUDENT)
                .build();

        User saved = userRepository.save(user);

        return UserResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .email(saved.getEmail())
                .phone(saved.getPhone())
                .role(saved.getRole())
                .department(saved.getDepartment())
                .createdAt(saved.getCreatedAt())
                .build();
    }
}