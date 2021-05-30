package ru.geekbrains.lession3.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class CalculatorKeyboardActivity extends Activity implements View.OnClickListener {
    private TextView outputResultText;
    private TextView inputedHistoryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_keyboard);

        initTextFields();
        initButtons();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id._0:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%d", inputedHistoryText.getText(), 0));
                break;
            case R.id._1:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%d", inputedHistoryText.getText(), 1));
                break;
            case R.id._2:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%d", inputedHistoryText.getText(), 2));
                break;
            case R.id._3:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%d", inputedHistoryText.getText(), 3));
                break;
            case R.id._4:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%d", inputedHistoryText.getText(), 4));
                break;
            case R.id._5:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%d", inputedHistoryText.getText(), 5));
                break;
            case R.id._6:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%d", inputedHistoryText.getText(), 6));
                break;
            case R.id._7:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%d", inputedHistoryText.getText(), 7));
                break;
            case R.id._8:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%d", inputedHistoryText.getText(), 8));
                break;
            case R.id._9:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%d", inputedHistoryText.getText(), 9));
                break;
            case R.id._equal:
                break;
            case R.id._zapitay:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%s", inputedHistoryText.getText(), ","));
                break;
            case R.id._backspace:
                inputedHistoryText.setText(String.format(Locale.getDefault(), ""));
                break;
            case R.id._bracket_close:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%s", inputedHistoryText.getText(), ")"));
                break;
            case R.id._backspace_one:
                if (inputedHistoryText.getText().length() > 0)
                {
                    inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", inputedHistoryText.getText().subSequence(0, inputedHistoryText.getText().length() - 1)));
                }
                break;
            case R.id._bracket_open:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%s", inputedHistoryText.getText(), "("));
                break;
            case R.id._divide:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%s", inputedHistoryText.getText(), "/"));
                break;
            case R.id._minus:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%s", inputedHistoryText.getText(), "-"));
                break;
            case R.id._multiply:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%s", inputedHistoryText.getText(), "*"));
                break;
            case R.id._percent:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%s", inputedHistoryText.getText(), "%"));
                break;
            case R.id._plus:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%s", inputedHistoryText.getText(), "+"));
                break;
            case R.id._plus_minus:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%s", inputedHistoryText.getText(), ""));
                break;
            case R.id._sqrt:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%s", inputedHistoryText.getText(), "КОР("));
                break;
            case R.id._stepen:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s%s", inputedHistoryText.getText(), "^("));
                break;
            default:
                break;
        }
    }

    private void initTextFields() {
        outputResultText = findViewById(R.id._RESULT);
        inputedHistoryText = findViewById(R.id._inputed_history_text);
    }

    private void initButtons() {
        // Numbers
        Button button_0 = findViewById(R.id._0);
        button_0.setOnClickListener(this);
        Button button_1 = findViewById(R.id._1);
        button_1.setOnClickListener(this);
        Button button_2 = findViewById(R.id._2);
        button_2.setOnClickListener(this);
        Button button_3 = findViewById(R.id._3);
        button_3.setOnClickListener(this);
        Button button_4 = findViewById(R.id._4);
        button_4.setOnClickListener(this);
        Button button_5 = findViewById(R.id._5);
        button_5.setOnClickListener(this);
        Button button_6 = findViewById(R.id._6);
        button_6.setOnClickListener(this);
        Button button_7 = findViewById(R.id._7);
        button_7.setOnClickListener(this);
        Button button_8 = findViewById(R.id._8);
        button_8.setOnClickListener(this);
        Button button_9 = findViewById(R.id._9);
        button_9.setOnClickListener(this);

        // Actions
        Button button_equal = findViewById(R.id._equal);
        button_equal.setOnClickListener(this);
        Button button_zapitay = findViewById(R.id._zapitay);
        button_zapitay.setOnClickListener(this);
        Button button_backspace = findViewById(R.id._backspace);
        button_backspace.setOnClickListener(this);
        Button button_bracket_close = findViewById(R.id._bracket_close);
        button_bracket_close.setOnClickListener(this);
        Button button_backspace_one = findViewById(R.id._backspace_one);
        button_backspace_one.setOnClickListener(this);
        Button button_bracket_open = findViewById(R.id._bracket_open);
        button_bracket_open.setOnClickListener(this);
        Button button_divide = findViewById(R.id._divide);
        button_divide.setOnClickListener(this);
        Button button_minus = findViewById(R.id._minus);
        button_minus.setOnClickListener(this);
        Button button_multiply = findViewById(R.id._multiply);
        button_multiply.setOnClickListener(this);
        Button button_percent = findViewById(R.id._percent);
        button_percent.setOnClickListener(this);
        Button button_plus = findViewById(R.id._plus);
        button_plus.setOnClickListener(this);
        Button button_plus_minus = findViewById(R.id._plus_minus);
        button_plus_minus.setOnClickListener(this);
        Button button_sqrt = findViewById(R.id._sqrt);
        button_sqrt.setOnClickListener(this);
        Button button_stepen = findViewById(R.id._stepen);
        button_stepen.setOnClickListener(this);
    }
}
