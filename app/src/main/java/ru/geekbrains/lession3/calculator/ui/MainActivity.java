package ru.geekbrains.lession3.calculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.geekbrains.lession3.calculator.R;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonRunCalculator = findViewById(R.id.runCalculator);
        buttonRunCalculator.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, CalculatorKeyboardActivity.class);
                startActivity(intent);
            }
        });
    }
}