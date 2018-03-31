package com.maman11;

public class Date {
    private static final String DELIMITER = "/";

    private int day;
    private int month;
    private int year;

    /**
     * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
     */
    public Date(int day, int month, int year) {
        //if date is not valid (day or month or year are not valid) - initialize with 1/1/2000
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

    /**
     * copy constructor
     */
    public Date(Date other) {
        this(other.day, other.month, other.year);
    }

    /**
     * check if 2 dates are the same
     */
    public boolean equals(Date other) {
        if (other == null)
            return false;

        //same object is equal
        if (other == this)
            return true;

        //otherwise - check equality of day, month, year
        return (other.day == this.day && other.month == this.month && other.year == this.year);
    }

    /**
     * gets the day
     */
    public int getDay() {
        return day;
    }

    /**
     * gets the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * gets the year
     */
    public int getYear() {
        return year;
    }

    /**
     * sets the day (only if date remains valid)
     */
    public void setDay(int dayToSet) {
        if (isValidDay(dayToSet)) {
            day = dayToSet;
        } else {
            day = 1;
        }
    }

    /**
     * sets the month (only if date remains valid)
     */
    public void setMonth(int monthToSet) {
        if (isValidMonth(monthToSet)) {
            this.month = monthToSet;
        } else {
            month = 1;
        }
    }

    /**
     * sets the year (only if date remains valid)
     */
    public void setYear(int yearToSet) {
        if (isValidYear(yearToSet)) {
            year = yearToSet;
        } else {
            year = 2000;
        }
    }

    /**
     * check if this daate is after other date
     */
    public boolean after(Date other) {
        return other.before(this);
    }

    /**
     * check if this date is after other date
     */
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

    /**
     * returns a String that represents this date
     */
    @Override
    public String toString() {
        return day + DELIMITER + month + DELIMITER + year;
    }

    /**
     * check if day is valid
     */
    private boolean isValidDay(int day) {
        //day should be between 1 and 31
        return (day >= 1 && day <= 31);
    }

    /**
     * check if month is valid
     */
    private boolean isValidMonth(int month) {
        //month should be between 1 and 12
        return (month >= 1 && month <= 12);
    }

    /**
     * check if year is valid
     */
    private boolean isValidYear(int year) {
        //year should be between 0 and 9999
        return (year >= 0 && year <= 9999);
    }
}
