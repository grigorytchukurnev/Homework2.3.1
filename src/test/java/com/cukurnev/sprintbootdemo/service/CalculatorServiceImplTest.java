package com.cukurnev.sprintbootdemo.service;

import com.cukurnev.sprintbootdemo.service.impl.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServiceImplTest {

    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    @Test
    public void shouldCorrectlyCalculateSum(){
        Integer num1 = 10;
        Integer num2 = 20;
        Integer expectedResult = 30;
        Assertions.assertEquals(expectedResult, calculatorService.plus(num1,num2) );
    }
    @Test
    public void shouldCorrectlyCalculateSumWithNegativeNumbers(){
        Integer num1 = -10;
        Integer num2 = -20;
        Integer expectedResult = -30;
        Assertions.assertEquals(expectedResult, calculatorService.plus(num1,num2) );
    }
    @Test
    public void shouldCorrectlyCalculateSubtraction(){
        Integer num1 = -10;
        Integer num2 = -20;
        Integer expectedResult = num1 - num2;
        Assertions.assertEquals(expectedResult, calculatorService.minus(num1,num2) );
    }
    @Test
    public void shouldCorrectlyCalculateMultiplication(){
        Integer num1 = 10;
        Integer num2 = 20;
        Integer expectedResult = 200;
        Assertions.assertEquals(expectedResult, calculatorService.multiply(num1,num2) );
    }
    @Test
    public void shouldCorrectlyCalculateDivision(){
        Integer num1 = 20;
        Integer num2 = 10;
        Integer expectedResult = 2;
        Assertions.assertEquals(expectedResult, calculatorService.divide(num1,num2) );
    }
    @Test
    public void shouldThrowExceptionWhenSecondArgumentIsZero(){
        Integer num1 = 10;
        Integer num2 = 0;
        Assertions.assertThrows
                (ArithmeticException.class,
                () -> calculatorService.divide(num1,num2)
        );
    }
}
