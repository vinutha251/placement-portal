package com.portal.placement.controller;  // ← must be this now

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "Backend working";
    }
}