package ru.skypro.javacourse2.calculator.Spring.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.skypro.javacourse2.calculator.Spring.calculator.exception.DivisionErrorException;
import ru.skypro.javacourse2.calculator.Spring.calculator.operation.impl.*;


import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();
    private final OperationService operationService = new OperationService();

    @Test
    void dividePositiveTest() {
        BaseOperation operation = operationService.createOperation(
            Divide.TYPE,
            10,
            2
        );

        String result = calculatorService.calculate(operation);
        assertEquals(result, "10 / 2 = 5");
    }

    @Test
    void divideNegativeTest() {
        BaseOperation operation = operationService.createOperation(
            Divide.TYPE,
            -2,
            10
        );

        String result = calculatorService.calculate(operation);
        assertEquals(result, "-2 / 10 = -0,2");
    }

    @Test
    void divideWithTrowTest() {
        BaseOperation operation = operationService.createOperation(
            Divide.TYPE,
            -2,
            0
        );

        assertThrows(DivisionErrorException.class, () -> calculatorService.calculate(operation));
    }

    @Test
    void minusPositiveTest() {
        BaseOperation operation = operationService.createOperation(
            Minus.TYPE,
            10,
            2
        );

        String result = calculatorService.calculate(operation);
        assertEquals(result, "10 - 2 = 8");
    }

    @Test
    void minusNegativeTest() {
        BaseOperation operation = operationService.createOperation(
            Minus.TYPE,
            -2,
            10
        );

        String result = calculatorService.calculate(operation);
        assertEquals(result, "-2 - 10 = -12");
    }

    @Test
    void multiplyPositiveTest() {
        BaseOperation operation = operationService.createOperation(
            Multiply.TYPE,
            10,
            2
        );

        String result = calculatorService.calculate(operation);
        assertEquals(result, "10 * 2 = 20");
    }

    @Test
    void multiplyNegativeTest() {
        BaseOperation operation = operationService.createOperation(
            Multiply.TYPE,
            -2,
            10
        );

        String result = calculatorService.calculate(operation);
        assertEquals(result, "-2 * 10 = -20");
    }

    @Test
    void plusPositiveTest() {
        BaseOperation operation = operationService.createOperation(
            Plus.TYPE,
            10,
            2
        );

        String result = calculatorService.calculate(operation);
        assertEquals(result, "10 + 2 = 12");
    }

    @Test
    void plusNegativeTest() {
        BaseOperation operation = operationService.createOperation(
            Plus.TYPE,
            -2,
            10
        );

        String result = calculatorService.calculate(operation);
        assertEquals(result, "-2 + 10 = 8");
    }

    // TODO параметризованные тесты

    @ParameterizedTest
    @MethodSource("getParametersDivideTest")
    void divideParameterizedTest(BaseOperation operation, String expected) {
        String result = calculatorService.calculate(operation);
        assertEquals(result, expected);
    }

    private Stream<Arguments> getParametersDivideTest() {
        return Stream.of(
            Arguments.of(operationService.createOperation(
                Divide.TYPE,
                2,
                10
            ), "2 / 10 = 0,2"),
            Arguments.of(operationService.createOperation(
                Divide.TYPE,
                -2,
                10
            ), "-2 / 10 = -0,2")
        );
    }

    @ParameterizedTest
    @MethodSource("getParametersMinusTest")
    void minusParameterizedTest(BaseOperation operation, String expected) {
        String result = calculatorService.calculate(operation);
        assertEquals(result, expected);
    }

    private Stream<Arguments> getParametersMinusTest() {
        return Stream.of(
            Arguments.of(operationService.createOperation(
                Minus.TYPE,
                2,
                10
            ), "2 - 10 = -8"),
            Arguments.of(operationService.createOperation(
                Minus.TYPE,
                -2,
                10
            ), "-2 - 10 = -12")
        );
    }

    @ParameterizedTest
    @MethodSource("getParametersMultiplyTest")
    void multiplyParameterizedTest(BaseOperation operation, String expected) {
        String result = calculatorService.calculate(operation);
        assertEquals(result, expected);
    }

    private Stream<Arguments> getParametersMultiplyTest() {
        return Stream.of(
            Arguments.of(operationService.createOperation(
                Multiply.TYPE,
                2,
                10
            ), "2 * 10 = 20"),
            Arguments.of(operationService.createOperation(
                Multiply.TYPE,
                -2,
                10
            ), "-2 * 10 = -20")
        );
    }

    @ParameterizedTest
    @MethodSource("getParametersPlusTest")
    void plusParameterizedTest(BaseOperation operation, String expected) {
        String result = calculatorService.calculate(operation);
        assertEquals(result, expected);
    }

    private Stream<Arguments> getParametersPlusTest() {
        return Stream.of(
            Arguments.of(operationService.createOperation(
                Plus.TYPE,
                2,
                10
            ), "2 + 10 = 12"),
            Arguments.of(operationService.createOperation(
                Plus.TYPE,
                -2,
                10
            ), "-2 + 10 = 8")
        );
    }
}