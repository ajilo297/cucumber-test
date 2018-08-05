package com.altorumleren.testdemo.calculator;

import android.content.Intent;
import android.os.SystemClock;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

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
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;

public class CalculatorActivitySteps {

    @Rule
    ActivityTestRule<CalculatorActivity> activityTestRule =
            new ActivityTestRule<>(CalculatorActivity.class, false, false);
    private CalculatorActivity activity;

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
        SystemClock.sleep(800);
        if (operator.matches("\\+")) {
            onView(withId(R.id.addButton)).perform(click());
        } else if (operator.matches("-")) {
            onView(withId(R.id.subButton)).perform(click());
        } else if (operator.matches("\\*")) {
            onView(withId(R.id.multiplyButton)).perform(click());
        } else if (operator.matches("/")) {
            onView(withId(R.id.divButton)).perform(click());
        } else if (operator.matches("clr")) {
            onView(withId(R.id.clrButton)).perform(click());
        }
    }

    @Then("^I should display (\\S+)$")
    public void iShouldDisplay(String output) {
        SystemClock.sleep(2500);
        onView(withId(R.id.output)).check(matches(withText(output)));
    }

    @When("^I enter some input$")
    public void iEnterSomeInput() {
        onView(withId(R.id.input1)).perform(typeText("34.5"), closeSoftKeyboard());
        SystemClock.sleep(800);
        onView(withId(R.id.input2)).perform(typeText("12.7"), closeSoftKeyboard());
    }

    @When("^I click on some operator$")
    public void iClickOnSomeOperator() {
        SystemClock.sleep(800);
        onView(withId(R.id.multiplyButton)).perform(click());
    }

    @When("^I press clear button$")
    public void iPressClearButton() {
        SystemClock.sleep(800);
        onView(withId(R.id.clrButton)).perform(click());
    }

    @Then("^All displays should reset$")
    public void allDisplaysShouldReset() {
        SystemClock.sleep(800);
        onView(withId(R.id.input1)).check(matches(withHint("0.0")));
        onView(withId(R.id.input2)).check(matches(withHint("0.0")));
        onView(withId(R.id.output)).check(matches(withHint("0.0")));
    }
}
