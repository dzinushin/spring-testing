package com.example.junit_demo;

public record Person(String name, int age) {
    boolean isAdult() {
        return age > 18;
    }
}
