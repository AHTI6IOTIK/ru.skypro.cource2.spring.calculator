package ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl;

public class Divide extends BaseOperation {

    @Override
    public boolean isSuccess() {
        boolean isSuccess = (getA() > 0 && getB() > 0);
        if (!isSuccess) {
            setError("Делить на 0 нельзя");
        }
        return isSuccess;
    }

    @Override
    public int calculate() {
        return getA() / getB();
    }

    @Override
    public String getCalculateMessage() {
        return String.format("%d / %d = %d", getA(), getB(), calculate());
    }
}
