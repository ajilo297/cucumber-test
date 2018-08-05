package com.altorumleren.testdemo.selector;

import android.content.Intent;
import android.view.View;

import com.altorumleren.testdemo.R;
import com.altorumleren.testdemo.calculator.CalculatorActivity;
import com.altorumleren.testdemo.login.LoginActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.robolectric.Shadows.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class SelectorTest {
    private SelectorActivity activity;

    @Before
    public void setup() {
        activity = spy(Robolectric.setupActivity(SelectorActivity.class));
    }

    @After
    public void tearDown() {
        activity = null;
    }

    @Test
    public void handleCalculatorClickTest() {
        View view = mock(View.class);
        when(view.getId()).thenReturn(R.id.calculator);
        activity.handleClick(view);
        activity.findViewById(R.id.calculator).performClick();
        verify(activity).handleCalculator();
    }

    @Test
    public void handleLoginClickTest() {
        View view = mock(View.class);
        when(view.getId()).thenReturn(R.id.login);
        activity.handleClick(view);
        verify(activity).handleLogin();
    }

    @Test
    public void handleLoginTest() {
        activity.handleLogin();
        Intent expectedIntent = new Intent(activity, LoginActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }

    @Test
    public void handleCalculatorTest() {
        activity.handleCalculator();
        Intent expectedIntent = new Intent(activity, CalculatorActivity.class);
        Intent actual = shadowOf(RuntimeEnvironment.application).getNextStartedActivity();
        assertEquals(expectedIntent.getComponent(), actual.getComponent());
    }
}
