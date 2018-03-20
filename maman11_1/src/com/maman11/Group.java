package com.maman11;

public class Group {
    private static final int MAX = 10;
    private Person[] personArr;
    private int personsCounter;


    public Group() {
        personArr = new Person[MAX];
        personsCounter = 0;
    }

    public boolean addPerson(Person p) {
        if (personsCounter == MAX)
            return false;

        for (int i = 0; i < personsCounter; i++) {
            if (personArr[i].equals(p))
                return false;
        }

        personArr[personsCounter] = p;
        personsCounter++;
        return true;
    }

    public int bornInDate(Date d) {
        int retVal = 0;

        for (int i = 0; i < personsCounter; i++) {
            if (personArr[i].getDateOfBirth().equals(d))
                retVal++;
        }

        return retVal;
    }

    public int bornInMonth(int m) {
        int retVal = 0;

        for (int i = 0; i < personsCounter; i++) {
            if (personArr[i].getDateOfBirth().getMonth() == m)
                retVal++;
        }

        return retVal;
    }

    public String firstPerson() {
        
    }

    public Person oldestPerson() {
        if (personsCounter == 0)
            return null;

        Person retVal = personArr[0];

        for (int i = 1; i < personsCounter; i++) {
            if (personArr[i].getDateOfBirth().before(retVal.getDateOfBirth()))
                retVal = personArr[i];
        }

        return retVal;
    }

    @Override
    public String toString() {
        String retVal = "";

        for (int i = 0; i < personsCounter; i++) {
            retVal += personArr[i] + "\r\n";
        }

        return retVal;
    }
}
