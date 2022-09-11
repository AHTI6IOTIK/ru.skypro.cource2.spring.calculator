package ru.skypro.javacourse2.calculator.Spring.calculator.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl.BaseOperation;
import ru.skypro.javacourse2.calculator.Spring.calculator.service.CalculatorService;
import ru.skypro.javacourse2.calculator.Spring.calculator.service.OperationService;

import java.util.Arrays;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    public final OperationService operationService;
    public final CalculatorService calculatorService;

    public CalculatorController(OperationService operationService, CalculatorService calculatorService) {
        this.operationService = operationService;
        this.calculatorService = calculatorService;
    }

    @GetMapping("/{operationName}")
    public String calculator(
        @PathVariable String operationName,
        @RequestParam double num1,
        @RequestParam double num2
    ) {
        BaseOperation operation = operationService.createOperation(
            operationName,
            num1,
            num2
        );

        if (null == operation) {
            return String.format(
                "Не известная операция. Допустимые операции: {%s}",
                Arrays.toString(operationService.getExistingTypes())
            );
        }

        return calculatorService.calculate(operation);
    }
}
