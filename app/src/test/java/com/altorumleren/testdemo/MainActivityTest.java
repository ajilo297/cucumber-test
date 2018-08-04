package com.altorumleren.testdemo;

import android.widget.EditText;

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
}