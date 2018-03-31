package com.maman11;

public class Person {
    private String firstName;
    private String lastName;
    private long id;
    private Date dateOfBirth;

    /**
     * creates a new person
     */
    public Person(String first, String last, long id, int d, int m, int y) {
        setFirstName(first);
        setLastName(last);
        setId(id);
        setDateOfBirth(d, m, y);
    }

    /**
     * copy constructor
     */
    public Person(Person p) {
        this(p.firstName, p.lastName, p.id, p.dateOfBirth.getDay(), p.dateOfBirth.getMonth(), p.dateOfBirth.getYear());
    }

    /**
     * gets the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * gets the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * gets the id
     */
    public long getId() {
        return id;
    }

    /**
     * gets the date of birth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * sets the first name
     */
    public void setFirstName(String name) {
        this.firstName = name;
    }

    /**
     * sets the last name
     */
    public void setLastName(String name) {
        this.lastName = name;
    }

    /**
     * sets the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     */
    public void setDateOfBirth(int d, int m, int y) {
        this.dateOfBirth = new Date(d, m, y);
    }

    /**
     * check if 2 persons are the same
     */
    public boolean equals(Person other) {
        if (other == null)
            return false;

        //same object is equal
        if (other == this)
            return true;

        //Otherwise - they are equal if the id is the same
        return (other.id == id);
    }

    /**
     * returns a String that represents this Person
     */
    @Override
    public String toString() {
        return "Last Name: " + lastName + ", First Name: " + firstName + ", ID: " + id + ", Date of birth: " + dateOfBirth;
    }
}
