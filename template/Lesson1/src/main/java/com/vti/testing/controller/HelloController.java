package com.vti.testing.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
@CrossOrigin("*")
public class HelloController {
    // Create Read Update Delete
    // POST   GET  PUT    DELETE
    @GetMapping
    public String hello() {
        return "Hello Spring";
    }
}
