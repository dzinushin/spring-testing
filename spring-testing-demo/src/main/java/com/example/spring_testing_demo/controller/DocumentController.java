package com.example.spring_testing_demo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("documents")
@RequiredArgsConstructor
@Slf4j
public class DocumentController {

    @GetMapping
    String getDoc() {
        return "Doc";
    }
}
