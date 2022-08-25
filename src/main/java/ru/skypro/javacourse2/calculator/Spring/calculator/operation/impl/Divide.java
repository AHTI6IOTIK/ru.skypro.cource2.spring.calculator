package ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl;

public class Divide extends BaseOperation {

    @Override
    public boolean isSuccess() {
        boolean hasError = (getA() == 0 || getB() == 0);
        if (hasError) {
            setError("Делить на 0 нельзя");
            return false;
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
