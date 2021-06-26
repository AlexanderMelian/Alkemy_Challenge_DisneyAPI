package com.alkemy.DisneyAPI.controller;

import lombok.AllArgsConstructor;

import com.alkemy.DisneyAPI.model.RegistrationRequest;
import com.alkemy.DisneyAPI.services.RegistrationService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "auth/register")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
