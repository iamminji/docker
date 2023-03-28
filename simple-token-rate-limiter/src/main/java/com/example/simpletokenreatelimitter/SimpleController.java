package com.example.simpletokenreatelimitter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private final TokenService tokenService;

    public SimpleController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/take")
    public String get() {
        tokenService.take();
        return "success";
    }
}
