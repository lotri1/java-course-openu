package com.maman11;

public class Group {
    private static final int MAX = 10;
    private Person[] personArr;
    private int personsCounter;


    /**
     * creates a new group
     */
    public Group() {
        //initialize the array with MAX person cells, and set the counter to 0 persons
        personArr = new Person[MAX];
        personsCounter = 0;
    }

    /**
     * adds a person to the group
     */
    public boolean addPerson(Person p) {
        //if the array is full - cannot add the person - return false
        if (personsCounter == MAX)
            return false;

        //check if the added person is already in the group
        for (int i = 0; i < personsCounter; i++) {
            if (personArr[i].equals(p))
                return false; //an equal person exists in the group - cannot add the same person - return false
        }

        //adding the new person
        personArr[personsCounter] = p;
        personsCounter++;

        return true;
    }

    /**
     * count the number of persons that was born in a date
     */
    public int bornInDate(Date d) {
        int retVal = 0;

        //go over the persons array
        for (int i = 0; i < personsCounter; i++) {
            //if the birth date of this person is equal to the date parameter
            if (personArr[i].getDateOfBirth().equals(d))
                retVal++; //increment the counter
        }

        return retVal;
    }

    /**
     * count the number of persons that was born in a month
     */
    public int bornInMonth(int m) {
        int retVal = 0;

        //go over the persons array
        for (int i = 0; i < personsCounter; i++) {
            //if the month of the birth date of this person is equal to the month parameter
            if (personArr[i].getDateOfBirth().getMonth() == m)
                retVal++; //increment the counter
        }

        return retVal;
    }

    /**
     * returns the first name of the person that is name (last name & first name) is first in alphabetical order
     */
    public String firstPerson() {
        //persons array is empty - return null
        if (personsCounter == 0)
            return null;

        //initialize the return value with the first person in the array
        Person retVal = personArr[0];

        //go over the persons array
        for (int i = 1; i < personsCounter; i++) {
            //compare the last name of the current iterated person with the last name of the returned person
            int lastNameCompareResult = personArr[i].getLastName().compareTo(retVal.getLastName());

            //current iterated person last name is alphabetically smaller
            if (lastNameCompareResult < 0) {
                retVal = personArr[i]; //the current iterated person should be the returned value - change it
            }

            //current iterated person is equal
            if (lastNameCompareResult == 0) {
                //compare the first names
                int firstNameCompareResult = personArr[i].getFirstName().compareTo(retVal.getFirstName());

                //current iterated person first name is alphabetically smaller
                if (firstNameCompareResult < 0) {
                    retVal = personArr[i]; //the current iterated person should be the returned value - change it
                }
            }
        }

        //return the first name of the selected person
        return retVal.getFirstName();
    }

    /**
     * returns the oldest person in the group
     */
    public Person oldestPerson() {
        //persons array is empty - return null
        if (personsCounter == 0)
            return null;

        //initialize the return value with the first person in the array
        Person retVal = personArr[0];

        //go over the persons array
        for (int i = 1; i < personsCounter; i++) {
            //check if the current iterated person birth date is before the returned person birth date
            if (personArr[i].getDateOfBirth().before(retVal.getDateOfBirth()))
                retVal = personArr[i]; //the current iterated person should be the returned value - change it
        }

        return retVal;
    }

    /**
     * returns a String that represents this group
     */
    @Override
    public String toString() {
        String retVal = "";

        //go over the array of persons and concatenate each of them in a new line
        for (int i = 0; i < personsCounter; i++) {
            retVal += personArr[i] + "\r\n";
        }

        return retVal;
    }
}
