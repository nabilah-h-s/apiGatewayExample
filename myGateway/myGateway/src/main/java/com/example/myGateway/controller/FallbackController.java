package com.example.myGateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback/service-b")
    public ResponseEntity<String> fallbackServiceB() {
        return ResponseEntity.ok("Service B is currently unavailable. Please try again later.");
    }
}
