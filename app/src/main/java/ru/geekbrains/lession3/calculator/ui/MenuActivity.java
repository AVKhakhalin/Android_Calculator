package ru.geekbrains.lession3.calculator.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ru.geekbrains.lession3.calculator.R;
import ru.geekbrains.lession3.calculator.calculator_logic.ThemeStorage;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private ThemeStorage themeStorage = new ThemeStorage();
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        // Инициализация кнопок
        initButtons();

        // Установка нового - фона
        Bundle arguments = getIntent().getExtras();
        if (arguments != null)
        {
            int curTheme = Integer.parseInt(arguments.get("settingTheme").toString());
            themeStorage.setIsLightTheme(curTheme);

            view = (View) findViewById(R.id._menu_background_theme);
            if (themeStorage.getIsLightTheme() == 1)
            {
                view.setBackgroundResource(R.drawable.back_calc);
            }
            else
            {
                view.setBackgroundResource(R.drawable.back_calc_dark);
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id._light_theme:
                view = (View) findViewById(R.id._menu_background_theme);
                view.setBackgroundResource(R.drawable.back_calc);
                themeStorage.setIsLightTheme(1);
                break;
            case R.id._dark_theme:
                view = (View) findViewById(R.id._menu_background_theme);
                view.setBackgroundResource(R.drawable.back_calc_dark);
                themeStorage.setIsLightTheme(0);
                break;
            case R.id._return:
                Intent menuIntent = new Intent(MenuActivity.this, CalculatorKeyboardActivity.class);
                menuIntent.putExtra("settingTheme", themeStorage.getIsLightTheme());
                startActivity(menuIntent);
                break;
            default:
                break;
        }
    }

    private void initButtons() {
        Button light_theme_button = findViewById(R.id._light_theme);
        light_theme_button.setOnClickListener(this);
        Button dark_theme_button = findViewById(R.id._dark_theme);
        dark_theme_button.setOnClickListener(this);
        Button return_button = findViewById(R.id._return);
        return_button.setOnClickListener(this);
    }

    // Метод для сохранения ссылки на класс ThemeStorage при повороте экрана
    public Object onRetainNonConfigurationInstanceTheme() {
        return themeStorage;
    }
}