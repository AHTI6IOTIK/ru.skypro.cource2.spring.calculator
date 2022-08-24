package ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl;

import ru.skypro.javacourse2.calculator.Spring.calculator.operation.OperationInterface;

public abstract class BaseOperation implements OperationInterface, Cloneable {

    private int a;

    private int b;

    private String error;

    public int getA() {
        return a;
    }

    public BaseOperation setA(int a) {
        this.a = a;
        return this;
    }

    public int getB() {
        return b;
    }

    public BaseOperation setB(int b) {
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

    @Override
    public BaseOperation clone() {
        try {
            return (BaseOperation) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Ошибка создания копии");
            return null;
        }
    }
}
