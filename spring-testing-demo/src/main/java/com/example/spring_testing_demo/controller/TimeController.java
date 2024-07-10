package com.example.spring_testing_demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequiredArgsConstructor
public class TimeController {
    private static final DateTimeFormatter DATE_TIME_FORMAT= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final Clock clock;

    @GetMapping("/time")
    String time() {
        var now = LocalDateTime.now(clock);
        return now.format(DATE_TIME_FORMAT);
    }

}
