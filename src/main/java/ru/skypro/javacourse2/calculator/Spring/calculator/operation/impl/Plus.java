package ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl;

public class Plus extends BaseOperation {
    @Override
    public int calculate() {
        return getA() + getB();
    }

    @Override
    public String getCalculateMessage() {
        return String.format("%d + %d = %d", getA(), getB(), calculate());
    }
}
