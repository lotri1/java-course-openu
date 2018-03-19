public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {

    }

    public Date(Date other) {
        day = other.day;
        month = other.month;
        year = other.year;
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

    public void setDay(int dayToSet) {
        if (dayToSet < 1 || dayToSet > 31)
            day = 1;
        else
            day = dayToSet;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int monthToSet) {
        if (monthToSet < 1 || monthToSet > 12)
            month = 1;
        else
            this.month = monthToSet;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int yearToSet) {
        if (yearToSet < 0 || yearToSet > 9999)
            year = 2000;
        else
            year = yearToSet;
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
        return day + "/" + month + "/" + year;
    }
}
