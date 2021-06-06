package ru.geekbrains.lession3.calculator.calculator_logic;

import java.util.LinkedList;
import java.util.ListIterator;

public class CalcLogic implements Constants
{
    LinkedList<Dates> inputNumbers;                // Создание класса со значениями
    int maxBracketLevel;                           // Максимальный уровень вложенности во всех скобках
    int curBracketLevel;                           // Создание переменной с текущим максимальный уровнем вложенности скобок
    int curNumber;                                 // Текущий индекс создаваемой операции (в операцию входит как сама операция, так и число в ней участвующее)
    LinkedList<Dates> inputNumbersForBracketCalc;  // Класс со значениями вместе со скобками;
                                                   // в результате всех вычислений, в данном классе не останется ни одной скобки
    LinkedList<Dates> inputNumbersForBaseCalc;     // Класс со значениями для вычислений внутри скобок
    ListIterator<Dates> iterInputNumbersForCalc;   // Создание итератора для навигации по списку со значениями

    public CalcLogic()
    {
        inputNumbers = new LinkedList<>();
        maxBracketLevel = 0;
        curBracketLevel = 0;
        curNumber = 0;
        inputNumbersForBaseCalc = new LinkedList<>();
        iterInputNumbersForCalc = inputNumbersForBaseCalc.listIterator();

        // Создание первого пустого элемента
        add(false, false, FUNC_NO, 1, 0d, false, ACT_PLUS, false);
    }

    public void addNumeral(int newNumeral)
    {
        if ((inputNumbers.get(curNumber).getIsBracket() == true) && (inputNumbers.get(curNumber).getIsClose() == false))
        {
            add(false, false, FUNC_NO, 1, 0d, false, ACT_PLUS, false);
            curNumber++;
        }
        if (inputNumbers.get(curNumber).getTurnOffZapitay() == false)
        {
            inputNumbers.get(curNumber).setNumberZapitay(inputNumbers.get(curNumber).getNumberZapitay() + 1);
            set(curNumber, inputNumbers.get(curNumber).getIsBracket(), false, FUNC_NO, curBracketLevel, inputNumbers.get(curNumber).getSign(), inputNumbers.get(curNumber).getValue() + Math.pow(10, -inputNumbers.get(curNumber).getNumberZapitay()) * (double) (newNumeral), true, inputNumbers.get(curNumber).getAction(), inputNumbers.get(curNumber).getIsPercent());
            inputNumbers.get(curNumber).setValueFract(inputNumbers.get(curNumber).getValueFract() + String.format("%d", newNumeral));
        }
        else
        {
            set(curNumber, inputNumbers.get(curNumber).getIsBracket(), false, FUNC_NO, curBracketLevel, inputNumbers.get(curNumber).getSign(), (int) inputNumbers.get(curNumber).getValue() * 10 + (double) (newNumeral) + (inputNumbers.get(curNumber).getValue() - (int) inputNumbers.get(curNumber).getValue()), true, inputNumbers.get(curNumber).getAction(), inputNumbers.get(curNumber).getIsPercent());
        }
    }

    public void add(boolean _isBracket, boolean _isClose, int _typeFuncInBracket, int _sign, double _value, boolean _isValue, int _action, boolean _isPercent)
    {
        inputNumbers.add(new Dates(_isBracket, _isClose, _typeFuncInBracket, curBracketLevel , _sign, _value, _isValue, _action, _isPercent));
    }

    public void set(int posNumber, boolean _isBracket, boolean _isClose, int _typeFuncInBracket, int _bracketLevel, int _sign, double _value, boolean _isValue, int _action, boolean _isPercent)
    {
        inputNumbers.get(posNumber).setIsBracket(_isBracket);
        inputNumbers.get(posNumber).setIsClose(_isClose);
        inputNumbers.get(posNumber).setTypeFuncInBracket(_typeFuncInBracket);
        inputNumbers.get(posNumber).setBracketLevel(_bracketLevel);
        inputNumbers.get(posNumber).setSign(_sign);
        inputNumbers.get(posNumber).setValue(_value);
        inputNumbers.get(posNumber).setIsValue(_isValue);
        inputNumbers.get(posNumber).setAction(_action);
        inputNumbers.get(posNumber).setPercent(_isPercent);
    }

//    public boolean setNewLevelBracket(boolean isCloseCurBracket /*true - закрываем текущую скобку, false - открываем текущую скобку*/, int _action)
/*    {
        if (isCloseCurBracket == false)
        {
            curBracketLevel++;
            add(true, false, FUNC_NO,1, 0d, false, _action, false);
            return true;
        }
        else
        {
            if (curBracketLevel > 0)
            {
                curBracketLevel--;
                return true;
            }
            else
            {
                return false;
            }
        }
    }
*/
    public void clearAll()
    {
        inputNumbers = new LinkedList<>();
        maxBracketLevel = 0;
        curBracketLevel = 0;
        curNumber = 0;
        // Создание первого пустого элемента
        add(false, false, FUNC_NO,1, 0d, false, ACT_PLUS, false);
    }

    public void clearOne()
    {
        if (curNumber > 0)
        {
//            if (inputNumbers.get(curNumber).getIsValue() == true)
//            {
//                if (inputNumbers.get(curNumber).getNumberZapitay() > 0)
//                {

//                    inputNumbers.get(curNumber).setIsValue();

//                    inputNumbers.get(curNumber).setValueFract(inputNumbers.get(curNumber).getValueFract().substring(0, inputNumbers.get(curNumber).getNumberZapitay() - 1));
//                    inputNumbers.get(curNumber).setNumberZapitay(inputNumbers.get(curNumber).getNumberZapitay() - 1);
//                }
//                else
//                {

//                }
// inputNumbers.get(curNumber).getValue() + Math.pow(10, -inputNumbers.get(curNumber).getNumberZapitay()) * (double) (newNumeral)
// (int) inputNumbers.get(curNumber).getValue() * 10 + (double) (newNumeral) + (inputNumbers.get(curNumber).getValue() - (int) inputNumbers.get(curNumber).getValue())
// valueFract
//            }
//            else
 //           {
                inputNumbers.remove(curNumber);
                curNumber--;
 //           }
        }
        else
        {
            clearAll();
        }
    }

    // Класс для копирования списков с объектами
    private LinkedList<Dates> copyLinkedList(LinkedList<Dates> originalInputNumbers)
    {
        Dates curDates;
        LinkedList<Dates> newInputNumbers = new LinkedList<>();

        iterInputNumbersForCalc = originalInputNumbers.listIterator();
        while (iterInputNumbersForCalc.hasNext())
        {
            curDates = iterInputNumbersForCalc.next();
            newInputNumbers.add(new Dates(curDates.getIsBracket(), curDates.getIsClose(), curDates.getTypeFuncInBracket(), curDates.getBracketLevel(), curDates.getSign(), curDates.getValue(), curDates.getIsValue(), curDates.getValueFract(), curDates.getAction(), curDates.getIsPercent(), curDates.getNumberZapitay(), curDates.getTurnOffZapitay()));
        }
        return newInputNumbers;
    }

    // Основной вычисляющий метод
    public double calculate()
    {
        int counter = -1;
        int startBracketIndex = -1;
        int maxBracketLevel = curBracketLevel;
        double tempBracketValue = 0d;
        double result = 0d;
        Dates curDates;
        Dates prevDates;

        inputNumbersForBracketCalc = copyLinkedList(inputNumbers); // Создание дубликата класса с числами для обработки со скобками
        // Здесь происходит обработка всех скобок
        for (int i = maxBracketLevel; i > 0; i--)
        {
            iterInputNumbersForCalc = inputNumbersForBracketCalc.listIterator();
            while (iterInputNumbersForCalc.hasNext())
            {
                counter++;
                curDates = iterInputNumbersForCalc.next();
                if (curDates.getBracketLevel() == i)
                {
                    startBracketIndex = counter; // Не забыть вернуть этой переменной значение -1, когда встретим закрывающую скобку
                }
                inputNumbersForBaseCalc = new LinkedList<>();
                while (iterInputNumbersForCalc.hasNext())
                {
                    curDates = iterInputNumbersForCalc.next();
                    if ((curDates.getBracketLevel() == i) && (curDates.getIsClose() == false))
                    {
                        inputNumbersForBaseCalc.add(new Dates(curDates.getIsBracket(), curDates.getIsClose(), curDates.getTypeFuncInBracket(), curDates.getBracketLevel(), curDates.getSign(), curDates.getValue(), curDates.getIsValue(), curDates.getValueFract(), curDates.getAction(), curDates.getIsPercent(), curDates.getNumberZapitay(), curDates.getTurnOffZapitay()));
                        iterInputNumbersForCalc.remove();
                    }
                    else if ((curDates.getBracketLevel() == i) && (curDates.getIsClose() == true))
                    {
                        inputNumbersForBaseCalc.add(new Dates(curDates.getIsBracket(), curDates.getIsClose(), curDates.getTypeFuncInBracket(), curDates.getBracketLevel(), curDates.getSign(), curDates.getValue(), curDates.getIsValue(), curDates.getValueFract(), curDates.getAction(), curDates.getIsPercent(), curDates.getNumberZapitay(), curDates.getTurnOffZapitay()));
                        iterInputNumbersForCalc.remove();
                        break;
                    }
                    else
                    {
                        if (iterInputNumbersForCalc.hasPrevious() == true)
                        {
                            iterInputNumbersForCalc.previous();
                        }
                        break;
                    }
                }
                result = moveOnWithoutBracket(inputNumbersForBaseCalc);
                inputNumbersForBracketCalc.get(startBracketIndex).setValue(doFunction(result, inputNumbersForBracketCalc.get(startBracketIndex).getTypeFuncInBracket()));
                inputNumbersForBracketCalc.get(startBracketIndex).setTypeFuncInBracket(FUNC_NO);
                inputNumbersForBracketCalc.get(startBracketIndex).setIsValue(true);
                inputNumbersForBracketCalc.get(startBracketIndex).setBracketLevel(inputNumbersForBracketCalc.get(startBracketIndex).getBracketLevel() - 1);
                startBracketIndex = -1;
            }
        }

        // Здесь происходит обработка списка, в котором не осталось ни одной скобки
        inputNumbersForBaseCalc = copyLinkedList(inputNumbers); // Создание дубликата класса с числами для обработки без скобок
        result = moveOnWithoutBracket(inputNumbersForBaseCalc);

        return result;
    }

    private double doFunction(double value, int typeFuncInBracket)
    {
        double result = value;

        switch (typeFuncInBracket)
        {
            case FUNC_SQRT:
                if (value >= 0)
                {
                    result = Math.sqrt(value);
                }
                else
                {
                    // Добавить сообщение об ошибке: выражение под корнем не может быть меньше нуля!
                }
                break;
            default:
                break;
        }
        return result;
    }

    private double moveOnWithoutBracket(LinkedList<Dates> curNumbersForCals)
    {
        double result = 0d;
        Dates curDates;
        Dates prevDates;

        // Проход по всем элементам, пока не останется только один элемент с результатом
        prevDates = curNumbersForCals.get(0);
        for(int i = 0; i < BASE_ACTIONS.length; i++)
        {
            iterInputNumbersForCalc = curNumbersForCals.listIterator();
            while (iterInputNumbersForCalc.hasNext())
            {
                curDates = iterInputNumbersForCalc.next();

                if ((curDates.getAction() == BASE_ACTIONS[i]) && (curNumbersForCals.size() > 1))
                {
                    prevDates.setValue(doBaseActions(prevDates.getValue() * prevDates.getSign(), curDates.getValue() * curDates.getSign(), curDates.getAction()));
                    prevDates.setSign(1);
                    iterInputNumbersForCalc.remove();
                }
                else
                {
                    prevDates = curDates;
                }
            }
            if (curNumbersForCals.size() == 1)
            {
                break;
            }
        }

        result = curNumbersForCals.get(0).getValue() * curNumbersForCals.get(0).getSign();

        return result;
    }

    private double doBaseActions(double number1, double number2, int action)
    {
        double result = 0d;
        switch (action)
        {
            case ACT_STEP:
                result = Math.pow(number1, number2);
                break;
            case ACT_PERS_DIV:
                result = (number1 * number2 != 0? (number1 / (number1 * number2 / 100)) : (0));
                // ДОБАВИТЬ УВЕДОМЛЕНИЕ ОБ ОШИБКЕ В СЛУЧАЕ ДЕЛЕНИЯ НА НОЛЬ
                break;
            case ACT_PERS_MULTY:
                result = number1 * (number1 * number2 / 100);
                break;
            case ACT_PERS_PLUS:
                result = number1 + number1 * number2 / 100;
                break;
            case ACT_PERS_MINUS:
                result = number1 - number1 * number2 / 100;
                break;
            case ACT_DIV:
                    result = (number2 != 0? (number1 / number2) : (0));
                    // ДОБАВИТЬ УВЕДОМЛЕНИЕ ОБ ОШИБКЕ В СЛУЧАЕ ДЕЛЕНИЯ НА НОЛЬ
                break;
            case ACT_MULTY:
                result = number1 * number2;
                break;
            case ACT_PLUS:
                result = number1 + number2;
                break;
            case ACT_MINUS:
                result = number1 - number2;
                break;
            default:
                break;
        }
        return result;
    }

 //   public double getCurValue()
 //   {
 //       return inputNumbers.get(curNumber).getValue();
 //   }

    public void setCurZapitay()
    {
        if (inputNumbers.get(curNumber).getTurnOffZapitay() == true)
        {
            inputNumbers.get(curNumber).setTurnOffZapitay(false);
            if (inputNumbers.get(curNumber).getNumberZapitay() < 0)
            {
                inputNumbers.get(curNumber).setNumberZapitay(0);
            }
        }
        else
        {
            inputNumbers.get(curNumber).setTurnOffZapitay(true);
        }
    }

    public int getCurZapitay()
    {
        return inputNumbers.get(curNumber).getNumberZapitay();
    }

    public int getCurNumber()
    {
        return curNumber;
    }

    public String setNewFunction(int typeFuncInBracket) // Данный метод не только устанавливает новую функцию, но и открывает скобку
    {
        if (inputNumbers.get(curNumber).getIsBracket() == true)
//        if ((inputNumbers.get(curNumber).getTypeFuncInBracket() != FUNC_NO) || (inputNumbers.get(curNumber).getIsValue() == true))
        {
            curBracketLevel++;
            add(true, false, typeFuncInBracket, 1, 0d, false, ACT_PLUS, false);
            curNumber++;
        }
        else
        {
            curBracketLevel++;
            inputNumbers.get(curNumber).setIsBracket(true);
            inputNumbers.get(curNumber).setBracketLevel(curBracketLevel);
            inputNumbers.get(curNumber).setTypeFuncInBracket(typeFuncInBracket);
        }
        if (maxBracketLevel < curBracketLevel)
        {
            maxBracketLevel = curBracketLevel;
        }
        return createOutput();
    }

    public String closeBracket()
    {
        if (curBracketLevel > 0)
        {
            if ((inputNumbers.get(curNumber).getIsBracket() == false) && (inputNumbers.get(curNumber).getIsClose() == false))
            {
                inputNumbers.get(curNumber).setIsBracket(true);
                inputNumbers.get(curNumber).setIsClose(true);
                curBracketLevel--;
            }
            else
            {
                curBracketLevel--;
                add(true, true, FUNC_NO, 1, 0d, false, ACT_PLUS, false);
                curNumber++;
            }
        }
        return createOutput();
    }

    public void setNewAction(int action)
    {
        boolean isPrevDatesComplited = false;
        if (curNumber > 0)
        {
            iterInputNumbersForCalc = inputNumbers.listIterator();
            Dates prevDates = iterInputNumbersForCalc.next();
            if ((prevDates.getIsValue() == true) || ((prevDates.getIsBracket() == true) && (prevDates.getIsClose() == false)) || ((prevDates.getIsBracket() == true) && (prevDates.getIsClose() == true)))
            {
                isPrevDatesComplited = true;
            }
        }
        else
        {
            isPrevDatesComplited = true;
        }

        if (inputNumbers.get(curNumber).getIsValue() == false)
        {
            if (inputNumbers.size() > 1)
            {
                inputNumbers.get(curNumber).setAction(action);
            }
            else
            {
                // Вывести сообщение о том, что нужно сначала ввести число
            }
        }
        else
        {
            if (action == ACT_PERS_MULTY)
            {
                if (inputNumbers.get(curNumber).getAction() == ACT_MULTY)
                {
                    inputNumbers.get(curNumber).setAction(ACT_PERS_MULTY);
                }
                else if (inputNumbers.get(curNumber).getAction() == ACT_DIV)
                {
                    inputNumbers.get(curNumber).setAction(ACT_PERS_DIV);
                }
                else if (inputNumbers.get(curNumber).getAction() == ACT_PLUS)
                {
                    inputNumbers.get(curNumber).setAction(ACT_PERS_PLUS);
                }
                else if (inputNumbers.get(curNumber).getAction() == ACT_MINUS)
                {
                    inputNumbers.get(curNumber).setAction(ACT_PERS_MINUS);
                }
                else
                {
                    // Вывести сообщение о том, что процент нужно применять только к простым арифметическим операциям *, /, +, -
                }
            }
            else
            {
                if (isPrevDatesComplited == true)
                {
                    add(false, false, FUNC_NO, 1, 0d, false, action, false);
                    curNumber++;
                }
            }
        }
    }

    public void changeSign()
    {
        inputNumbers.get(curNumber).setSign(inputNumbers.get(curNumber).getSign() * (-1));
    }

//    public int getLastAction()
//    {
//        return inputNumbers.get(curNumber).getAction();
//    }

    public String createOutput()
    {
        String outputString = "";
        Dates curDates;
        Dates prevDates = null;
//        int counter = -1;

        iterInputNumbersForCalc = inputNumbers.listIterator();

        while (iterInputNumbersForCalc.hasNext())
        {
            curDates = iterInputNumbersForCalc.next();
//            counter++;
            outputString += outputStringActionAndFunction(prevDates, curDates);
//            if (counter == 0)
//            {
//                outputString += outputStringActionAndFunction(curDates.getIsBracket(), curDates.getIsClose(), curDates.getTypeFuncInBracket(),curDates.getValue() * curDates.getSign(), curDates.getIsValue(), curDates.getNumberZapitay(), curDates.getValueFract(), curDates.getAction(), true);
//            }
//            else
//            {
//                outputString += outputStringActionAndFunction(curDates.getIsBracket(), curDates.getIsClose(), curDates.getTypeFuncInBracket(),curDates.getValue() * curDates.getSign(), curDates.getIsValue(), curDates.getNumberZapitay(), curDates.getValueFract(), curDates.getAction(), false);
//            }
            prevDates = curDates;
        }

        return outputString;
    }

    private String outputStringFunctionOpen(Dates curDates)
    {
        String stringFunction = "";
        if ((curDates.getIsBracket() == true) && (curDates.getIsClose() == false))
        {
            switch (curDates.getTypeFuncInBracket())
            {
                case FUNC_SQRT:
                    stringFunction = "SQRT(";
                    break;
                // Сюда можно добавить другие функции для их отображения
                default:
                    stringFunction = "(";
                    break;
            }
        }
        return stringFunction;
    }

    private String outputStringFunctionClose(boolean isBracket, boolean isClose)
    {
        String stringFunction = "";
        if ((isBracket == true) && (isClose == true))
        {
            stringFunction = ")";
        }
        return stringFunction;
    }

    private String outputStringActionAndFunction(Dates prevDates, Dates curDates)
    {
        boolean isBracket = curDates.getIsBracket();
        boolean isClose = curDates.getIsClose();
        int typeFuncInBracket = curDates.getTypeFuncInBracket();
        int bracketLevel = curDates.getBracketLevel();
        int sign = curDates.getSign();
        double value = curDates.getValue();
        boolean isValue = curDates.getIsValue();
        String valueFract = curDates.getValueFract();
        int action = curDates.getAction();
        boolean isPercent = curDates.getIsPercent();
        int numberZapitay = curDates.getNumberZapitay();
        boolean turnOffZapitay = curDates.getTurnOffZapitay();

        boolean isPrevBraketOpen = false;
        if ((prevDates != null) && (prevDates.getIsBracket() == true) && (prevDates.getIsClose() == false))
        {
            isPrevBraketOpen = true;
        }
        boolean isFirst = (prevDates == null ? true : false);
        String stringAction = "";
        String valueString;
        if (valueFract.equals("") == true)
        {
//            valueString = (numberZapitay == 0 ? String.format("%d.%s", (int) value,  outputStringFunctionClose(isBracket, isClose)) : String.format("%d%s", (int) value,  outputStringFunctionClose(isBracket, isClose)));
            valueString = (numberZapitay == 0 ? String.format("%d.", (int) value) : String.format("%d", (int) value));
        }
        else
        {
//            valueString = String.format("%d.%s%s", (int) value, valueFract, outputStringFunctionClose(isBracket, isClose));
            valueString = String.format("%d.%s", (int) value, valueFract);
        }

        if (isFirst == false)
        {
            switch (action) {
                case ACT_STEP:
                    if (isValue == true)
                    {
                        stringAction = "^" + outputStringFunctionOpen(curDates) + String.format("%s", valueString) + (isClose == true ? ")" : "");
                    }
                    else
                    {
                        stringAction = "^" + outputStringFunctionOpen(curDates);
                    }
                    break;
                case ACT_PERS_MULTY:
                    stringAction = "*" + outputStringFunctionOpen(curDates) + (value >= 0 ? String.format("%s", valueString) : ("(-" + String.format("%s", valueString) + ")")) + "%" + (isClose == true ? ")" : "");
                    break;
                case ACT_PERS_DIV:
                    stringAction = "/" + outputStringFunctionOpen(curDates) + (value >= 0 ? String.format("%s", valueString) : ("(-" + String.format("%s", valueString) + ")")) + "%" + (isClose == true ? ")" : "");
                    break;
                case ACT_PERS_PLUS:
                    stringAction = (isPrevBraketOpen == false ? "+" : "") + outputStringFunctionOpen(curDates) + (value >= 0 ? String.format("%s", valueString) : ("(-" + String.format("%s", valueString) + ")")) + "%" + (isClose == true ? ")" : "");
                    break;
                case ACT_PERS_MINUS:
                    stringAction = "-" + outputStringFunctionOpen(curDates) + (value >= 0 ? String.format("%s", valueString) : ("(-" + String.format("%s", valueString) + ")")) + "%" + (isClose == true ? ")" : "");
                    break;
                case ACT_MULTY:
                    if (isValue == true)
                    {
                        stringAction = "*" + outputStringFunctionOpen(curDates) + (value >= 0 ? String.format("%s", valueString) : ("(-" + String.format("%s", valueString) + ")")) + (isClose == true ? ")" : "");
                    }
                    else
                    {
                        stringAction = "*" + outputStringFunctionOpen(curDates) + (isClose == true ? ")" : "");
                    }
                    break;
                case ACT_DIV:
                    if (isValue == true)
                    {
                        stringAction = "/" + outputStringFunctionOpen(curDates) + (value >= 0 ? String.format("%s", valueString) : ("(-" + String.format("%s", valueString) + ")")) + (isClose == true ? ")" : "");
                    }
                    else
                    {
                        stringAction = "/" + outputStringFunctionOpen(curDates) + (isClose == true ? ")" : "");
                    }
                    break;
                case ACT_PLUS:
                    if (isValue == true)
                    {
                        stringAction = (isPrevBraketOpen == false ? "+" : "") + outputStringFunctionOpen(curDates) + (value >= 0 ? String.format("%s", valueString) : ("(-" + String.format("%s", valueString) + ")")) + (isClose == true ? ")" : "");
                    }
                    else
                    {
                        if (curDates.getIsClose() == false)
                        {
                            stringAction = (isPrevBraketOpen == false ? "+" : "") + outputStringFunctionOpen(curDates);
                        }
                        else
                        {
                            stringAction = ")";
                        }
                    }
                    break;
                case ACT_MINUS:
                    if (isValue == true)
                    {
                        stringAction = (value >= 0 ? "-" : "+") + outputStringFunctionOpen(curDates) + String.format("%s", valueString) + (isClose == true ? ")" : "");
                    }
                    else
                    {
                        stringAction = (value >= 0 ? "-" : "+") + outputStringFunctionOpen(curDates) + (isClose == true ? ")" : "");
                    }
                    break;
            }
        }
        else
        {
            switch (action) {
                case ACT_PLUS:
                    if (isValue == true)
                    {
                        stringAction = outputStringFunctionOpen(curDates) + String.format("%s", valueString);
                    }
                    else
                    {
                        stringAction = outputStringFunctionOpen(curDates);
                    }
                    break;
            }
        }
        return stringAction;
    }
}
