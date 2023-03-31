package com.cukurnev.sprintbootdemo.controller;

import com.cukurnev.sprintbootdemo.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greeting(){
        return  "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public String plus(
            @RequestParam(name = "num1",required = false) Integer num1,
            @RequestParam(name = "num2",required = false) Integer num2
    ) {
        if (num1==null || num2==null){
            return "Проверьте правильность ввернных данных num1 или num2.";
        }

        return calculatorService.plus(num1, num2).toString();
    }

    @GetMapping("/minus")
    public String minus(
            @RequestParam(name = "num1",required = false) Integer num1,
            @RequestParam(name = "num2",required = false) Integer num2
    ) {
        if (num1==null || num2==null){
            return "Проверьте правильность ввернных данных num1 или num2";
        }
        return calculatorService.minus(num1, num2).toString();
    }

    @GetMapping("/multiply")
    public String multiply(
            @RequestParam(name = "num1",required = false) Integer num1,
            @RequestParam(name = "num2",required = false) Integer num2
    ) {
        if (num1==null || num2==null){
            return "Проверьте правильность ввернных данных num1 или num2";
        }
        return calculatorService.multiply(num1,num2).toString();
    }

    @GetMapping("/divide")
    public String divide(
            @RequestParam(name = "num1",required = false) Integer num1,
            @RequestParam(name = "num2",required = false) Integer num2
    ) {
        if (num1==null || num2==null){
            return "Проверьте правильность ввернных данных num1 или num2";}
        if (num2.equals(0)){
            return "Делить на ноль нельзя!!!!";
        }
        return calculatorService.divide(num1, num2).toString();
    }
}
