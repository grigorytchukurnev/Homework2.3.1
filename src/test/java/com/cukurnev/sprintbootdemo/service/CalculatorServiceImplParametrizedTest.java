package com.cukurnev.sprintbootdemo.service;

import com.cukurnev.sprintbootdemo.service.impl.CalculatorServiceImpl;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceImplParametrizedTest {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();
    public static Stream<Arguments> argumentsSourceForSumTest(){
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(-1, 1, 0),
                Arguments.of(0, 0, 0)
        );
    }
    public static Stream<Arguments> argumentsSourceForMultiplyTest(){
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(-1, 0, 0),
                Arguments.of(10, 10, 100)
        );
    }
    @ParameterizedTest
    @MethodSource("argumentsSourceForSumTest")
    public void shouldCorrectlyCalculateSum(Integer num1, Integer num2, Integer expectedResult ){
        Assertions.assertEquals(expectedResult, calculatorService.plus(num1, num2));

    }
    @ParameterizedTest
    @MethodSource("argumentsSourceForMultiplyTest")
    public void shouldCorrectlyCalculateMultiplication(Integer num1, Integer num2, Integer expectedResult ){
        Assertions.assertEquals(expectedResult, calculatorService.multiply(num1, num2));

    }
}
