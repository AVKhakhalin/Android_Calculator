package ru.geekbrains.lession3.calculator.calculator_logic;

// Класс для хранения единичных данных, используется в списке
public class Dates implements Constants {
    private boolean isBracket;      // является ли данный элемент скобкой: true = да; false = нет;
                                    // открывающаяся скобка является пустым объектом, в неё потом размещается результат вычислений всех операций в данной скобке; пустой объект имеет вначале value = 0d;
                                    // закрывающая скобка находится в самом последнем объекте данной скобки; т.е. последний объект в скобке имеет свойство isBracket = true, что говорит о том, что скобка закрылась
    private boolean isClose;   // признак закрывающей скобки; у последнего элемента в скобке будет isClose = true, а у остальных элементов в скобке isClose = false
    private FUNCTIONS typeFuncInBracket;  // тип функции, которую нужно применить ко все скобке; все типы фукнции описаны в интерфейсе Constants
    private int bracketLevel;  // уровень скобки: чем выше уровень, тем более глубоко вложена данная скобка в другие скобки; начальный уровень - 0
    private int sign;               // знак числа: либо +1, либо -1; по-умолчанию, значение +1
    private double value;      // числовое значение
    private boolean isValue;        // признак задания числа; по-умолчанию, все числа задаются 0d; если хотя бы одну цифру в число внесли, то isValue = true; по-умолчанию isValue = false
    private String valueFract; // дробная часть величины value для удобного представления числа в поле inputedHistoryText
    private ACTIONS action;        // производимые действия над числом (по-умолчанию стоит сумма ACT_PLUS):
                                    // ACT_STEP         - возведение в степень (ACT_STEP);
                                    // ACT_PERS_MULTY   - вычисление произведения на процент от числа (ACT_PERS_MULTY);
                                    // ACT_PERS_DIV     - вычисление деления на процент от числа (ACT_PERS_DIV);
                                    // ACT_PERS_MINUS   - вычисление вычистания процента от числа (ACT_PERS_MINUS);
                                    // ACT_PERS_PLUS    - вычисление сложения с процентом от числа (ACT_PERS_PLUS);
                                    // ACT_MULTY        - умножение (ACT_MULTY);
                                    // ACT_DIV          - деление (ACT_DIV);
                                    // ACT_MINUS        - вычитание (ACT_MINUS)
                                    // ACT_PLUS         - сложение (ACT_PLUS);
    private boolean isPercent; // является ли данный элемент процентом: true = да; false = нет
    private int numberZapitay;      // количество разрядов после запятой; по-умолчанию -1, что означает, что разрядов нет;
                                    // при нажатии на кнопку с запятой, к данному числу прибавляется единица и оно становится равным нулю;
                                    // при дальнейшем нажатии (после запятой) на любую из цифр, к numberZapitay прибавляется единица и к числу прибавляетс следующая величина: Math.pow(10, -numberZapitay) * NUMERAL
    private boolean turnOffZapitay;     // выключение режима ввода дробных знаков при повторном нажатии на запятую; по-умолчанию turnOffZapitay = true, т.е. вводятся только цифры целого числа;
                                        // если один раз нажать на запятую, то turnOffZapitay = false и начнут вводиться цифры после запятой;
                                        // если ещё раз нажать на запятую, то turnOffZapitay = false опять начнут вводиться цифры только в целую часть числа и т.д.

    Dates(boolean _isBracket, boolean _isClose, FUNCTIONS _typeFuncInBracket, int _bracketLevel, int _sign, double _value, boolean _isValue, ACTIONS _action, boolean _isPercent) {
        isBracket = _isBracket;
        isClose = _isClose;
        typeFuncInBracket = _typeFuncInBracket;
        bracketLevel = _bracketLevel;
        sign = _sign;
        value = _value;
        isValue = _isValue;
        valueFract = "";
        action = _action;
        isPercent = _isPercent;
            numberZapitay = -1;
            turnOffZapitay = true;
    }

    Dates(boolean _isBracket, boolean _isClose, FUNCTIONS _typeFuncInBracket, int _bracketLevel, int _sign, double _value, boolean _isValue, String _valueFract, ACTIONS _action, boolean _isPercent, int _numberZapitay, boolean _turnOffZapitay) {
        isBracket = _isBracket;
        isClose = _isClose;
        typeFuncInBracket = _typeFuncInBracket;
        bracketLevel = _bracketLevel;
        sign = _sign;
        value = _value;
        isValue = _isValue;
        valueFract = _valueFract;
        action = _action;
        isPercent = _isPercent;
        numberZapitay = _numberZapitay;
        turnOffZapitay = _turnOffZapitay;
    }

    public boolean getIsBracket() {
        return isBracket;
    }

    public boolean getIsClose() {
        return isClose;
    }

    public FUNCTIONS getTypeFuncInBracket() {
        return typeFuncInBracket;
    }

    public int getBracketLevel() {
        return bracketLevel;
    }

    public int getSign() {
        return sign;
    }

    public double getValue() {
        return value;
    }

    public boolean getIsValue() {
        return isValue;
    }

    public String getValueFract() {
        return valueFract;
    }

    public ACTIONS getAction() {
        return action;
    }

    public boolean getIsPercent() {
        return isPercent;
    }

    public int getNumberZapitay()
    {
        return numberZapitay;
    }

    public boolean getTurnOffZapitay() {
        return turnOffZapitay;
    }

    public void setIsBracket(boolean bracket) {
        isBracket = bracket;
    }

    public void setIsClose(boolean close)
    {
        isClose = close;
    }

    public void setTypeFuncInBracket(FUNCTIONS _typeFuncInBracket) {
        typeFuncInBracket = _typeFuncInBracket;
    }

    public void setBracketLevel(int _bracketLevel) {
        bracketLevel = _bracketLevel;
    }

    public void setSign(int _sign) {
        sign = _sign;
    }

    public void setValue(double _value) {
        value = _value;
    }

    public void setIsValue(boolean _isValue) {
        isValue = _isValue;
    }

    public void setValueFract(String _valueFract) {
        valueFract = _valueFract;
    }

    public void setAction(ACTIONS _action) {
        action = _action;
    }

    public void setIsPercent(boolean percent) {
        isPercent = percent;
    }

    public void setNumberZapitay(int _numberZapitay)
    {
        numberZapitay = _numberZapitay;
    }

    public void setTurnOffZapitay(boolean _turnOffZapitay) {
        turnOffZapitay = _turnOffZapitay;
    }
}
