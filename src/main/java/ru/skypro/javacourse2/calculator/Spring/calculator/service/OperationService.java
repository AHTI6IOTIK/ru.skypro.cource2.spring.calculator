package ru.skypro.javacourse2.calculator.Spring.calculator.service;

import org.springframework.stereotype.Service;
import ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl.*;

import java.util.HashMap;

@Service
public class OperationService {
    private final HashMap<String, String> operations = new HashMap<>();

    public OperationService() {
        operations.put("plus", Plus.class.getName());
        operations.put("multiply", Multiply.class.getName());
        operations.put("minus", Minus.class.getName());
        operations.put("divide", Divide.class.getName());
    }

    public BaseOperation createOperation(String operationName) {
        String className = operations.get(operationName.toLowerCase().trim());
        if (null == className) {
            return null;
        }

        try {
            return (BaseOperation) Class.forName(className).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    public BaseOperation configureOperation(BaseOperation operation, double a, double b) {
        operation.setA(a).setB(b);
        return operation;
    }

    public String[] getExistingTypes() {
        return operations.keySet().toArray(new String[0]);
    }
}
