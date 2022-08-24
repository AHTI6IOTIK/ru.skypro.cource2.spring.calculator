package ru.skypro.javacourse2.calculator.Spring.calculator.service;

import org.springframework.stereotype.Service;
import ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl.*;

import java.util.HashMap;

@Service
public class OperationService {
    private final HashMap<String, BaseOperation> operations = new HashMap<>();

    public OperationService() {
        operations.put("plus", new Plus());
        operations.put("multiply", new Multiply());
        operations.put("minus", new Minus());
        operations.put("divide", new Divide());
    }

    public BaseOperation createOperation(String operationName) {
        BaseOperation templateOperation = operations.get(operationName.toLowerCase().trim());
        if (null == templateOperation) {
            return null;
        }

        return templateOperation.clone();
    }

    public BaseOperation configureOperation(BaseOperation operation, int a, int b) {
        operation.setA(a).setB(b);
        return operation;
    }

    public String[] getExistingTypes() {
        return operations.keySet().toArray(new String[0]);
    }
}
