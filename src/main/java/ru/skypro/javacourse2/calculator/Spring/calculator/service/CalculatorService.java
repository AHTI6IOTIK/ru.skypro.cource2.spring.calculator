package ru.skypro.javacourse2.calculator.Spring.calculator.service;

import org.springframework.stereotype.Service;
import ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl.BaseOperation;

@Service
public class CalculatorService {

    public String calculate(BaseOperation operation) {
        if (!operation.isSuccess()) {
            return operation.getError();
        }

        return operation.getCalculateMessage();
    }
}
