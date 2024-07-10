package com.example.junit_demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitTest {

    Logger log = LoggerFactory.getLogger(this.getClass());

    public UnitTest() {
        // for every test run JUnit 5 creates new instance of test class
        log.info("> ctor");
    }

    @Test
    void test1() {
        log.info("> run test 1");
    }

    @Test
    void test2() {
        log.info("> run test2");
    }

    // example of simple parametrized test
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void parametrized_test(int param) {
        log.info("> run parametrized test with param: {}", param);
    }

    @ParameterizedTest
    @MethodSource("paramsSource")
    void parametrized_test_with_method_source(int arg1, String arg2, boolean arg3) {
        log.info("> run parametrized test with params: {} {} {}", arg1, arg2, arg3);
    }

    static Stream<Arguments> paramsSource() {
        return Stream.of(
                Arguments.arguments(1, "1", true),
                Arguments.arguments(2, "2", false),
                Arguments.arguments(3, "3", true)
        );
    }

    @Test
    void assertjUse() {

        Person michaelJackson = new Person("Michael Jackson", 60);
        log.info("Person michaelJackson: {}", michaelJackson);

        assertThat(michaelJackson)
                .extracting(Person::name, Person::age, Person::isAdult)
                .containsExactly("Michael Jackson", 60, true);
    }
}
