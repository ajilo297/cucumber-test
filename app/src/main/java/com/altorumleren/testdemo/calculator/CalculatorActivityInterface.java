package com.altorumleren.testdemo.calculator;

import android.view.View;
import android.widget.EditText;

public interface CalculatorActivityInterface {

    float add(float o1, float o2);

    float subtract(float o1, float o2);

    float multiply(float o1, float o2);

    float divide(float o1, float o2);

    boolean fieldsHaveValues(String s1, String s2);

    String getTextFromField(EditText editText);

    float[] getOperands();

    void clearDisplay();

    void setDisplay(Object o);

    void handleOperation(View view);

    void handleAddition();

    void handleSubtraction();

    void handleDivision();

    void handleMultiplication();
}
