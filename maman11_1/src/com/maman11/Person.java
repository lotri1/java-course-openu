package com.maman11;

public class Person {
    private String firstName;
    private String lastName;
    private long id;
    private Date dateOfBirth;

    public Person(String first, String last, long id, int d, int m, int y) {
        setFirstName(first);
        setLastName(last);
        setId(id);
        setDateOfBirth(d, m, y);
    }

    public Person(Person p) {
        this(p.firstName, p.lastName, p.id, p.dateOfBirth.getDay(), p.dateOfBirth.getMonth(), p.dateOfBirth.getYear());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getId() {
        return id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDateOfBirth(int d, int m, int y) {
        this.dateOfBirth = new Date(d, m, y);
    }

    public boolean equals(Person other) {
        if (other == null)
            return false;

        if (other == this)
            return true;

        return (other.id == id);
    }

    @Override
    public String toString() {
        return "Last Name: " + lastName + ", First Name: " + firstName + ", ID: " + id + ", Date of birth: " + dateOfBirth;
    }
}
