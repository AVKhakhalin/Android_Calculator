package ru.geekbrains.lession3.calculator.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ru.geekbrains.lession3.calculator.R;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        Button buttonRunCalculator = findViewById(R.id.runCalculator);
        buttonRunCalculator.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CalculatorKeyboardActivity.class);
            startActivity(intent);
        });
    }
}