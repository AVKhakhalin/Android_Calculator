package ru.geekbrains.lession3.calculator.calculator_logic;

public interface Constants
{
    // Действия
    public final int ACT_STEP       = 1;  // 1  - возведение в степень (ACT_STEP);
    public final int ACT_PERS_MULTY = 2;  // 2  - вычисление произведения на процент от числа (ACT_PERS_MULTY);
    public final int ACT_PERS_DIV   = 3;  // 3  - вычисление деления на процент от числа (ACT_PERS_DIV);
    public final int ACT_PERS_PLUS  = 4;  // 4  - вычисление сложения с процентом от числа (ACT_PERS_PLUS);
    public final int ACT_PERS_MINUS = 5;  // 5  - вычисление вычистания процента от числа (ACT_PERS_MINUS);
    public final int ACT_MULTY      = 6;  // 6  - умножение (ACT_MULTY);
    public final int ACT_DIV        = 7;  // 7  - деление (ACT_DIV);
    public final int ACT_MINUS      = 8;  // 8  - вычитание (ACT_MINUS);
    public final int ACT_PLUS       = 9;  // 9  - сложение (ACT_PLUS);
    public final int[] BASE_ACTIONS = {ACT_STEP, ACT_PERS_MULTY, ACT_PERS_DIV, ACT_PERS_PLUS, ACT_PERS_MINUS, ACT_MULTY, ACT_DIV, ACT_MINUS, ACT_PLUS};

    // Функции
    public final int FUNC_NO        = 0; // 0 - нет функции
    public final int FUNC_SQRT      = 1; // 1 - извлечение квадратного корня (ACT_SQRT)
    // сюда можно, в дальнейшем, дописать другие функции sin, cos, tang, exp, log и т.д.
}