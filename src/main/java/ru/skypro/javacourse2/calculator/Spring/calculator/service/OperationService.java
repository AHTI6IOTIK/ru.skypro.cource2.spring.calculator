package ru.skypro.javacourse2.calculator.Spring.calculator.service;

import org.springframework.stereotype.Service;
import ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl.*;

import java.util.HashMap;

@Service
public class OperationService {
    private final HashMap<String, String> operations = new HashMap<>();

    public OperationService() {
        operations.put(Plus.TYPE, Plus.class.getName());
        operations.put(Multiply.TYPE, Multiply.class.getName());
        operations.put(Minus.TYPE, Minus.class.getName());
        operations.put(Divide.TYPE, Divide.class.getName());
    }

    public BaseOperation createOperation(String operationName, double a, double b) {
        String className = operations.get(operationName.toLowerCase().trim());
        if (null == className) {
            return null;
        }

        try {
            return configureOperation(
                (BaseOperation) Class.forName(className).newInstance(),
                a,
                b
            );
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    private BaseOperation configureOperation(BaseOperation operation, double a, double b) {
        operation.setA(a).setB(b);
        return operation;
    }

    public String[] getExistingTypes() {
        return operations.keySet().toArray(new String[0]);
    }
}
