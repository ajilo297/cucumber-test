package com.altorumleren.testdemo;

import android.view.View;
import android.widget.EditText;

import net.bytebuddy.build.ToStringPlugin;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @After
    public void tearDown() {
        activity = null;
    }

    @Test
    public void add() {
        float output = activity.add(45.5f, 10f);
        assertEquals(55.5f, output, 0f);
    }

    @Test
    public void subtract() {
        float output = activity.subtract(45.5f, 10f);
        assertEquals(35.5f, output, 0f);
    }

    @Test
    public void multiply() {
        float output = activity.multiply(45.5f, 10f);
        assertEquals(455f, output, 0f);
    }

    @Test
    public void divide() {
        float output = activity.divide(45.5f, 10f);
        assertEquals(4.55f, output, 0f);
    }


    @Test
    public void getOperandsTest() {
        activity.input1.setText("100");
        activity.input2.setText("20");
        float[] outputArray1 = activity.getOperands();
        assertEquals(100f, outputArray1[0], 0);
        assertEquals(20f, outputArray1[1], 0);

        activity.input1.setText("");
        activity.input2.setText("");
        float[] outputArray2 = activity.getOperands();
        assertEquals(0, outputArray2.length);
    }

    @Test
    public void clearDisplayTest() {
        activity.clearDisplay();
        assertEquals("", activity.input1.getText().toString());
        assertEquals("", activity.input2.getText().toString());
        assertEquals("", activity.output.getText().toString());
    }

    @Test
    public void setDisplayTest() {
        activity.setDisplay("Infinity");
        assertEquals("Infinity", activity.output.getText().toString());
        activity.setDisplay(98.5f);
        assertEquals(98.5f, Float.parseFloat(activity.output.getText().toString()), 0);
        activity.setDisplay(new JSONObject());
        assertEquals("Invalid parameter",activity.output.getText().toString());
    }

    @Test
    public void handleTest() {
        activity.input1.setText("100");
        activity.input2.setText("20");
        activity.handleAddition();
        assertEquals("120.0", activity.output.getText().toString());
        activity.handleSubtraction();
        assertEquals("80.0", activity.output.getText().toString());
        activity.handleMultiplication();
        assertEquals("2000.0", activity.output.getText().toString());
        activity.handleDivision();
        assertEquals("5.0", activity.output.getText().toString());
        activity.clearDisplay();
        assertEquals("", activity.output.getText().toString());
        assertEquals("", activity.input1.getText().toString());
        assertEquals("", activity.input2.getText().toString());
    }

    @Test
    public void handleTestWithoutInit() {
        activity.handleAddition();
        assertEquals("Invalid input", activity.output.getText().toString());
        activity.handleSubtraction();
        assertEquals("Invalid input", activity.output.getText().toString());
        activity.handleMultiplication();
        assertEquals("Invalid input", activity.output.getText().toString());
        activity.handleDivision();
        assertEquals("Invalid input", activity.output.getText().toString());
    }

    @Test
    public void handleAddClickTest() {
        activity.input1.setText("100");
        activity.input2.setText("20");

        View view = mock(View.class);
        when(view.getId()).thenReturn(R.id.addButton);

        activity.handleOperation(view);
        assertEquals("120.0", activity.output.getText().toString());
    }

    @Test
    public void handleSubtractClickTest() {
        activity.input1.setText("100");
        activity.input2.setText("20");

        View view = mock(View.class);
        when(view.getId()).thenReturn(R.id.subButton);

        activity.handleOperation(view);
        assertEquals("80.0", activity.output.getText().toString());
    }

    @Test
    public void handleMultiplyClickTest() {
        activity.input1.setText("100");
        activity.input2.setText("20");

        View view = mock(View.class);
        when(view.getId()).thenReturn(R.id.multiplyButton);

        activity.handleOperation(view);
        assertEquals("2000.0", activity.output.getText().toString());
    }

    @Test
    public void handleDivideClickTest() {
        activity.input1.setText("100");
        activity.input2.setText("20");

        View view = mock(View.class);
        when(view.getId()).thenReturn(R.id.divButton);

        activity.handleOperation(view);
        assertEquals("5.0", activity.output.getText().toString());
    }

    @Test
    public void handleClearClickTest() {
        activity.input1.setText("100");
        activity.input2.setText("20");

        View view = mock(View.class);
        when(view.getId()).thenReturn(R.id.clrButton);

        activity.handleOperation(view);
        assertEquals("", activity.input1.getText().toString());
        assertEquals("", activity.input2.getText().toString());
        assertEquals("", activity.output.getText().toString());
    }
}