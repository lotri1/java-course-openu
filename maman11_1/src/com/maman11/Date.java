package com.maman11;

public class Date {
    private static final String DELIMITER = "/";

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (!isValidDay(day) || !isValidMonth(month) || !isValidYear(year)) {
            setDay(1);
            setMonth(1);
            setYear(2000);
        } else {
            setDay(day);
            setMonth(month);
            setYear(year);
        }
    }

    public Date(Date other) {
        this(other.day, other.month, other.year);
    }

    public boolean equals(Date other) {
        if (other == null)
            return false;

        if (other == this)
            return true;

        return (other.day == this.day && other.month == this.month && other.year == this.year);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int dayToSet) {
        if (isValidDay(dayToSet)) {
            day = dayToSet;
        } else {
            day = 1;
        }
    }

    public void setMonth(int monthToSet) {
        if (isValidMonth(monthToSet)) {
            this.month = monthToSet;
        } else {
            month = 1;
        }
    }

    public void setYear(int yearToSet) {
        if (isValidYear(yearToSet)) {
            year = yearToSet;
        } else {
            year = 2000;
        }
    }

    public boolean after(Date other) {
        return other.before(this);
    }

    public boolean before(Date other) {
        if (year < other.year)
            return true;

        if (year > other.year)
            return false;

        if (month < other.month)
            return true;

        if (month > other.month)
            return false;

        if (day < other.day)
            return true;

        return false;
    }

    @Override
    public String toString() {
        return day + DELIMITER + month + DELIMITER + year;
    }

    private boolean isValidDay(int day) {
        return (day >= 1 && day <= 31);
    }

    private boolean isValidMonth(int month) {
        return (month >= 1 && month <= 12);
    }

    private boolean isValidYear(int year) {
        return (year >= 0 && year <= 9999);
    }
}
