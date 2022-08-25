package ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl;

public class Minus extends BaseOperation {
    @Override
    public Number calculate() {
        return getA() - getB();
    }

    @Override
    public String getCalculateMessage() {
        return String.format(
            "%s - %s = %s",
            decimalFormat.format(getA()),
            decimalFormat.format(getB()),
            decimalFormat.format(calculate())
        );
    }
}
