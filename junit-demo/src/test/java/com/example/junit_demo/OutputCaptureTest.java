package com.example.junit_demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
public class OutputCaptureTest {
    @Test
    void name(CapturedOutput output) {

        System.out.println("ok");
        assertThat(output).contains("ok");
    }
}
