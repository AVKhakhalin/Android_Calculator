package ru.geekbrains.lession3.calculator.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import ru.geekbrains.lession3.calculator.calculator_logic.CalcLogic;
import ru.geekbrains.lession3.calculator.calculator_logic.Constants;
import ru.geekbrains.lession3.calculator.R;

public class CalculatorKeyboardActivity extends Activity implements View.OnClickListener, Constants {
    private TextView outputResultText;
    private TextView inputedHistoryText;

    public CalcLogic calcLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_keyboard);

        calcLogic = new CalcLogic();

        initTextFields();
        initButtons();
//        Toast.makeText(getApplicationContext(), String.valueOf(calcLogic.getCurZapitay()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id._0:
                calcLogic.addNumeral(0);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._1:
                calcLogic.addNumeral(1);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._2:
                calcLogic.addNumeral(2);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._3:
                calcLogic.addNumeral(3);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._4:
                calcLogic.addNumeral(4);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._5:
                calcLogic.addNumeral(5);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._6:
                calcLogic.addNumeral(6);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._7:
                calcLogic.addNumeral(7);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._8:
                calcLogic.addNumeral(8);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._9:
                calcLogic.addNumeral(9);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._equal:
                outputResultText.setText(String.format(Locale.getDefault(), "%e", calcLogic.calculate()));
                break;
            case R.id._zapitay:
                calcLogic.setCurZapitay();
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._bracket_open:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.setNewFunction(FUNCTIONS.FUNC_NO)));
                break;
            case R.id._bracket_close:
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.closeBracket()));
                break;
            case R.id._backspace:
                calcLogic.clearAll();
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                outputResultText.setText(String.format(Locale.getDefault(), ""));
                break;
            case R.id._backspace_one:
                calcLogic.clearOne();
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._divide:
                calcLogic.setNewAction(ACTIONS.ACT_DIV);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._minus:
                calcLogic.setNewAction(ACTIONS.ACT_MINUS);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._multiply:
                calcLogic.setNewAction(ACTIONS.ACT_MULTY);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._plus:
                calcLogic.setNewAction(ACTIONS.ACT_PLUS);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._percent:
                calcLogic.setNewAction(ACTIONS.ACT_PERS_MULTY); // Задаётся универсальное значение ACT_PERS_MULTY и оно уточняется в методе setNewAction
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._plus_minus:
                calcLogic.changeSign();
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._stepen:
                calcLogic.setNewAction(ACTIONS.ACT_STEP);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
                break;
            case R.id._sqrt:
                calcLogic.setNewFunction(FUNCTIONS.FUNC_SQRT);
                inputedHistoryText.setText(String.format(Locale.getDefault(), "%s", calcLogic.createOutput()));
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
