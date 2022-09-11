package ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl;

import ru.skypro.javacourse2.calculator.Spring.calculator.exception.DivisionErrorException;

public class Divide extends BaseOperation {
    public static final String TYPE = "divide";

    @Override
    public boolean isSuccess() {
        boolean hasError = (getA() == 0 || getB() == 0);
        if (hasError) {
            throw new DivisionErrorException();
        }

        return true;
    }

    @Override
    public Number calculate() {
        return getA() / getB();
    }

    @Override
    public String getCalculateMessage() {
        return String.format(
            "%s / %s = %s",
            decimalFormat.format(getA()),
            decimalFormat.format(getB()),
            decimalFormat.format(calculate())
        );
    }
}
