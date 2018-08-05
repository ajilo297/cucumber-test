package com.altorumleren.testdemo.selector;

import android.content.Intent;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;

import com.altorumleren.testdemo.R;
import com.altorumleren.testdemo.calculator.CalculatorActivity;
import com.altorumleren.testdemo.login.LoginActivity;

import org.junit.Rule;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;

public class SelectorSteps {

    @Rule
    ActivityTestRule<SelectorActivity> activityTestRule =
            new ActivityTestRule<>(SelectorActivity.class, false, false);
    SelectorActivity activity;

    @Before
    public void setup() {
        activityTestRule.launchActivity(new Intent());
        activity = activityTestRule.getActivity();
        Intents.init();
    }

    @After
    public void tearDown() {
        activityTestRule.finishActivity();
        activity = null;
        Intents.release();
    }

    @Given("^I have a Selector Activity$")
    public void iHaveASelectorActivity() {
        assertNotNull(activity);
    }

    @When("^I click on Login button$")
    public void iClickOnLoginButton() {
        onView(withId(R.id.login)).perform(click());
    }

    @Then("^I should see login activity$")
    public void iShouldSeeLoginActivity() {
        intended(hasComponent(LoginActivity.class.getName()));
    }

    @When("^I click on Calculator button$")
    public void iClickOnCalculatorButton() {
        onView(withId(R.id.calculator)).perform(click());
    }

    @Then("^I should see Calculator activity$")
    public void iShouldSeeCalculatorActivity() {
        intended(hasComponent(CalculatorActivity.class.getName()));
    }
}
