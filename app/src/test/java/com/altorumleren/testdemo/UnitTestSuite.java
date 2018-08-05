package com.altorumleren.testdemo;

import com.altorumleren.testdemo.calculator.CalculatorActivityTest;
import com.altorumleren.testdemo.selector.SelectorTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculatorActivityTest.class,
        SelectorTest.class
})
public class UnitTestSuite {
}
