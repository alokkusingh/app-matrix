package com.alok.app.matrix.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/app/hello")
public class HelloController {

    public static final UUID uuid = UUID.randomUUID();

    @Timed(value = "greeting.time", description = "Time taken to return greeting")
    @GetMapping("/greet")
    public String greet() {
        return "Hello from " + uuid.toString();
    }
}
