package com.altorumleren.testdemo;

import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements MainActivityInterface{

    @VisibleForTesting EditText input1;
    @VisibleForTesting EditText input2;
    @VisibleForTesting EditText output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        output = findViewById(R.id.output);

    }

    @Override
    public float add(float o1, float o2) {
        return Arithmetic.add(o1, o2);
    }

    @Override
    public float subtract(float o1, float o2) {
        return Arithmetic.subtract(o1, o2);
    }

    @Override
    public float multiply(float o1, float o2) {
        return Arithmetic.multiply(o1, o2);
    }

    @Override
    public float divide(float o1, float o2) {
        return Arithmetic.divide(o1, o2);
    }

    @Override
    public boolean fieldsHaveValues(String s1, String s2) {
        return !s1.matches("") && !s2.matches("");
    }

    @Override
    public String getTextFromField(EditText editText) {
        return editText == null ? "" : editText.getText().toString().trim();
    }

    @Override
    public float[] getOperands() {
        String o1String = getTextFromField(input1);
        String o2String = getTextFromField(input2);

        if (fieldsHaveValues(o1String, o2String)) {
            float o1 = Float.parseFloat(o1String);
            float o2 = Float.parseFloat(o2String);
            return new float[]{o1, o2};
        }
        return new float[0];
    }

    @Override
    public void clearDisplay() {
        input1.setText("");
        input2.setText("");
        output.setText("");
    }

    @Override
    public void setDisplay(Object o) {
        if (o instanceof String) {
            output.setText((String) o);
        } else if (o instanceof Float) {
            output.setText(String.valueOf(o));
        } else {
            output.setText("Invalid parameter");
        }
    }

    @Override
    public void handleOperation(View view) {
        if (view.getId() == R.id.addButton) {
            handleAddition();
        } else if (view.getId() == R.id.subButton) {
            handleSubtraction();
        } else if (view.getId() == R.id.multiplyButton) {
            handleMultiplication();
        } else if (view.getId() == R.id.divButton) {
            handleDivision();
        } else if (view.getId() == R.id.clrButton) {
            clearDisplay();
        }
    }

    @Override
    public void handleAddition() {
        float[] operands = getOperands();
        if (operands.length == 0) {
            setDisplay("Invalid input");
            return;
        }
        float o = add(operands[0], operands[1]);
        setDisplay(o);
    }

    @Override
    public void handleSubtraction() {
        float[] operands = getOperands();
        if (operands.length == 0) {
            setDisplay("Invalid input");
            return;
        }
        float o = subtract(operands[0], operands[1]);
        setDisplay(o);
    }

    @Override
    public void handleDivision() {
        float[] operands = getOperands();
        if (operands.length == 0) {
            setDisplay("Invalid input");
            return;
        }
        float o = divide(operands[0], operands[1]);
        setDisplay(o);
    }

    @Override
    public void handleMultiplication() {
        float[] operands = getOperands();
        if (operands.length == 0) {
            setDisplay("Invalid input");
            return;
        }
        float o = multiply(operands[0], operands[1]);
        setDisplay(o);
    }
}
