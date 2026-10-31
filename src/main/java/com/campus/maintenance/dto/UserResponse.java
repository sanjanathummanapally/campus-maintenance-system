package com.campus.maintenance.dto;

import java.time.LocalDateTime;

import com.campus.maintenance.entity.Role;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private Role role;
    private String department;
    private LocalDateTime createdAt;
}