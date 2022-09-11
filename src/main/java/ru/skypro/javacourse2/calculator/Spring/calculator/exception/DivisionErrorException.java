package ru.skypro.javacourse2.calculator.Spring.calculator.exception;

public class DivisionErrorException extends IllegalArgumentException {
    public DivisionErrorException() {
        super("Делить на 0 нельзя");
    }
}
