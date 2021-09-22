package com.alok.app.matrix.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/hello")
public class HelloController {

    @Timed(value = "greeting.time", description = "Time taken to return greeting")
    @GetMapping("/greet")
    public String greet() {
        return "Hello!";
    }
}
