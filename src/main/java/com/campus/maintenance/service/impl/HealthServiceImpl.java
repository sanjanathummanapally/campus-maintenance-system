package com.campus.maintenance.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.campus.maintenance.service.HealthService;

@Service
public class HealthServiceImpl implements HealthService {


    @Override
    public Map<String, String> getHealthStatus() {
        return Map.of(
                "status", "UP",
                "application", "Smart Campus Maintenance System"
        );
    }
}