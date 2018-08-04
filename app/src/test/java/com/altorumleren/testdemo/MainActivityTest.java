package com.altorumleren.testdemo;

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
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = spy(Robolectric.setupActivity(MainActivity.class));
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
        when(activity.getTextFromField(any(EditText.class))).thenReturn("4");
        float[] outputArray1 = activity.getOperands();
        assertEquals(4f, outputArray1[0], 0);
        assertEquals(4f, outputArray1[0], 0);

        when(activity.getTextFromField(any(EditText.class))).thenReturn("");
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
        when(activity.getTextFromField(any(EditText.class))).thenReturn("4");
        activity.handleAddition();
        assertEquals("8.0", activity.output.getText().toString());
        activity.handleSubtraction();
        assertEquals("0.0", activity.output.getText().toString());
        activity.handleMultiplication();
        assertEquals("16.0", activity.output.getText().toString());
        activity.handleDivision();
        assertEquals("1.0", activity.output.getText().toString());
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
}