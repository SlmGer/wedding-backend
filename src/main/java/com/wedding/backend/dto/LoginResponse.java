package com.wedding.backend.dto;

import lombok.Getter;

@Getter
public class LoginResponse {
    private boolean success;
    private String role;

    public LoginResponse(boolean success, String role) {
        this.success = success;
        this.role = role;
    }
}
