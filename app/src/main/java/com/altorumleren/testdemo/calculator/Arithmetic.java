package com.altorumleren.testdemo.calculator;

import org.jetbrains.annotations.Contract;

public class Arithmetic {

    private Arithmetic() {}

    @Contract(pure = true)
    public static float add(float a, float b) {
        return a + b;
    }

    @Contract(pure = true)
    public static float subtract(float a, float b) {
        return a - b;
    }

    @Contract(pure = true)
    public static float multiply(float a, float b) {
        return a * b;
    }

    @Contract(pure = true)
    public static float divide(float a, float b) {
        return a / b;
    }
}
