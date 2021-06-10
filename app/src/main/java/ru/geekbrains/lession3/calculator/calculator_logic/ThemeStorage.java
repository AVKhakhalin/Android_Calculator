package ru.geekbrains.lession3.calculator.calculator_logic;

import android.os.Parcel;
import android.os.Parcelable;

public class ThemeStorage implements Parcelable
{
    private int isLightTheme = 1;

    public ThemeStorage()
    {
    }

    public ThemeStorage(int _isLightTheme)
    {
        isLightTheme = _isLightTheme;
    }

    public int getIsLightTheme() {
        return isLightTheme;
    }

    public void setIsLightTheme(int lightTheme) {
        isLightTheme = lightTheme;
    }

    // Конструктор и методы для сохранения и восстановления данных
    protected ThemeStorage (Parcel in)
    {
        isLightTheme = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeInt(isLightTheme);
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    public static final Creator<ThemeStorage> CREATOR = new Creator<ThemeStorage>()
    {
        @Override
        public ThemeStorage createFromParcel(Parcel in)
        {
            return new ThemeStorage(in);
        }

        @Override
        public ThemeStorage[] newArray(int size) {
            return new ThemeStorage[0];
        }
    };
}
