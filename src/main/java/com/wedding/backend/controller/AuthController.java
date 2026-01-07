package com.wedding.backend.controller;

import com.wedding.backend.dto.LoginRequest;
import com.wedding.backend.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Value("${wedding.guest.password}")
    private String guestPassword;

    @Value("${wedding.admin.password}")
    private String adminPassword;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        if(guestPassword.equals(request.getPassword())) {
            return new LoginResponse(true, "GUEST");
        }
        if(adminPassword.equals(request.getPassword())) {
            return new LoginResponse(true, "ADMIN");
        }

        return new LoginResponse(false, null);
    }
}
