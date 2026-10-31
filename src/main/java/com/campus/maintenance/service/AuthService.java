package com.campus.maintenance.service;

import com.campus.maintenance.dto.RegisterRequest;
import com.campus.maintenance.dto.UserResponse;

public interface AuthService {

    UserResponse register(RegisterRequest request);
}