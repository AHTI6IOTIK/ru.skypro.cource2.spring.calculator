package ru.skypro.javacourse2.calculator.Spring.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl.BaseOperation;
import ru.skypro.javacourse2.calculator.Spring.calculator.service.CalculatorService;
import ru.skypro.javacourse2.calculator.Spring.calculator.service.OperationService;

import java.util.Arrays;

@RestController
public class CalculatorController {
    public final OperationService operationService;
    public final CalculatorService calculatorService;

    public CalculatorController(OperationService operationService, CalculatorService calculatorService) {
        this.operationService = operationService;
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator/{operationName}")
    public String calculator(
        @PathVariable String operationName,
        @RequestParam double num1,
        @RequestParam double num2
    ) {
        BaseOperation operation = operationService.createOperation(operationName);

        if (null == operation) {
            return String.format(
                "Не известная операция. Допустимые операции: {%s}",
                Arrays.toString(operationService.getExistingTypes())
            );
        }

        return calculatorService.calculate(
            operationService.configureOperation(operation, num1, num2)
        );
    }
}
