package com.altorumleren.testdemo.selector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.altorumleren.testdemo.BaseActivity;
import com.altorumleren.testdemo.R;
import com.altorumleren.testdemo.calculator.CalculatorActivity;
import com.altorumleren.testdemo.login.LoginActivity;

public class SelectorActivity extends BaseActivity implements SelectorInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
    }

    @Override
    public void handleClick(View view) {
        if (view.getId() == R.id.login) {
            handleLogin();
        } else if (view.getId() == R.id.calculator) {
            handleCalculator();
        }
    }

    @Override
    public void handleLogin() {
        Intent intent = new Intent(SelectorActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void handleCalculator() {
        Intent intent = new Intent(SelectorActivity.this, CalculatorActivity.class);
        startActivity(intent);
    }
}
