package com.example.spring_testing_demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Clock;
import java.time.LocalDateTime;

import static java.time.ZoneOffset.UTC;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TimeController.class)
//@TestPropertySource(properties = "spring.main.allow-bean-definition-overriding=true")
class TimeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void should_render_current_datetime_in_required_format() throws Exception {
        var expectedAnswer = "2024-05-31 17:42:53";
        mockMvc.perform( get("/time"))
                .andExpect( status().isOk() )
                .andDo(print())
                .andExpect( content().string( is( equalTo(expectedAnswer) ) ) );
    }

    @TestConfiguration
    static class TimeControllerTestConfiguration {

        @Bean
        Clock clock() {
            LocalDateTime fixedDT = LocalDateTime.of(2024,5,31, 17, 42, 53);
            return Clock.fixed(fixedDT.toInstant(UTC), UTC);
        }
    }
}
