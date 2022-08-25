package ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl;

import ru.skypro.javacourse2.calculator.Spring.calculator.operation.OperationInterface;

import java.text.DecimalFormat;

public abstract class BaseOperation implements OperationInterface {

    protected DecimalFormat decimalFormat = new DecimalFormat("#.##########");

    private double a;

    private double b;

    private String error;

    public double getA() {
        return a;
    }

    public BaseOperation setA(double a) {
        this.a = a;
        return this;
    }

    public double getB() {
        return b;
    }

    public BaseOperation setB(double b) {
        this.b = b;
        return this;
    }

    public boolean isSuccess() {
        return true;
    }

    public BaseOperation setError(String error) {
        this.error = error;
        return this;
    }

    public String getError() {
        return error;
    }
}
