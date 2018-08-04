package com.altorumleren.testdemo.test;

import android.content.Intent;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.altorumleren.testdemo.MainActivity;
import com.altorumleren.testdemo.R;

import org.junit.Rule;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;

public class MainActivitySteps {

    @Rule
    ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class, false, false);
    private MainActivity activity;

    @Before
    public void setup() {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
    }

    @After
    public void tearDown() {
        activityTestRule.finishActivity();
        activity = null;
    }

    @Given("^I have a calculator activity$")
    public void iHaveACalculatorActivity() {
        assertNotNull(activity);
    }

    @When("^I enter operand1 (\\S+)$")
    public void iEnterOperand1(String o1) {
        onView(ViewMatchers.withId(R.id.input1)).perform(typeText(o1), closeSoftKeyboard());
    }

    @When("^I enter operand2 (\\S+)$")
    public void iEnterOperand2(String o1) {
        onView(withId(R.id.input2)).perform(typeText(o1), closeSoftKeyboard());
    }

    @When("^I select operator (\\S)$")
    public void iSelectOperator(String operator) {
        if (operator.matches("\\+")) {
            onView(withId(R.id.addButton)).perform(click());
        } else if (operator.matches("-")) {
            onView(withId(R.id.subButton)).perform(click());
        } else if (operator.matches("\\*")) {
            onView(withId(R.id.multiplyButton)).perform(click());
        } else if (operator.matches("/")) {
            onView(withId(R.id.divButton)).perform(click());
        }
    }

    @Then("^I should display (\\S+)$")
    public void iShouldDisplay(String output) {
        onView(withId(R.id.output)).check(matches(withText(output)));
    }
}