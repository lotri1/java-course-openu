package com.maman11;

import static java.lang.System.out;

public class Driver {
    public static void main(String[] args) {
        //initialize 2 groups for checking the scenarios
        Group group = new Group();
        Group emptyGroup = new Group();

        //Perform adding to the group
        printHeader("Adding people");

        addPerson(group, new Person("Shay", "Vaturi", 1, 28, 9, 1982));
        addPerson(group, new Person("Tzipi", "Shavit", 2, 3, 10, 1970));
        addPerson(group, new Person("Dudu", "Zar", 3, 2, 10, 1970));

        //Check adding existing person to the group
        printSmallHeader("Add same person twice");
        Person person = new Person("Yossi", "Cohen", 4, 3, 10, 1970);
        addPerson(group, person);
        addPerson(group, new Person(person));
        printEndSmallHeader();

        //Illegal birth date
        printSmallHeader("Add persons with illegal day");
        addPerson(group, new Person("Zeev", "Revach", 5, 0, 11, 1995));
        addPerson(group, new Person("Uzi", "Hitman", 6, 32, 11, 1995));
        printEndSmallHeader();

        printSmallHeader("Add persons with illegal month");
        addPerson(group, new Person("Yehoran", "Gaon", 7, 7, 0, 1995));
        addPerson(group, new Person("Ilan", "Banay", 8, 8, 13, 1995));
        printEndSmallHeader();

        printSmallHeader("Add persons with illegal year");
        addPerson(group, new Person("Evyatar", "Banay", 9, 2, 10, -1));
        addPerson(group, new Person("Moshe", "Sagee", 10, 2, 10, 10000));
        printEndSmallHeader();

        //add to full group
        printSmallHeader("Add person to full group");
        addPerson(group, new Person("Yeahuda", "Barkan", 11, 2, 10, -1));
        printEndSmallHeader();

        printHeader("Done adding people");

        //print groups
        printHeader("Print the group using the toString of the group:");
        out.printf(group.toString());
        printHeader("Done printing the group");

        printHeader("Print empty group:");
        out.printf(emptyGroup.toString());
        printHeader("Done printing empty group");

        //oldest person
        printHeader("Print oldest person:");
        printOldestPersonName("Oldest person: ", group);
        printOldestPersonName("Oldest person of empty group: ", emptyGroup);
        printHeader("Done printing oldest person");

        //first person
        printHeader("Print first name of first person:");
        out.println("First person: " + group.firstPerson());
        out.println("First person empty group: " + emptyGroup.firstPerson());
        printHeader("Done printing first person");

        //born in date
        printHeader("Born in date:");
        out.println("Born in date 28/9/1982: " + group.bornInDate(new Date(28, 9, 1982)));
        out.println("Born in date 1/1/2000: " + group.bornInDate(new Date(1, 1, 2000)));
        out.println("Born in date 3/10/1970: " + group.bornInDate(new Date(3, 10, 1970)));
        out.println("Born in date 1/1/2010: " + group.bornInDate(new Date(1, 1, 2010)));
        out.println("Born in date 1/1/2010 in empty group: " + group.bornInDate(new Date(1, 1, 2010)));
        printHeader("Done born in date");

        //born in month
        printHeader("Born in month:");
        out.println("Born in month 10: " + group.bornInMonth(10));
        out.println("Born in month 1: " + group.bornInMonth(1));
        out.println("Born in month 3: " + group.bornInMonth(3));
        out.println("Born in month 10 in empty group: " + emptyGroup.bornInMonth(10));
        printHeader("Done born in month");
    }

    /**
     * add person to a group and print the result to the screen
     */
    private static void addPerson(Group group, Person person) {
        if (group.addPerson(person))
            out.println("Person was added: " + person);
        else
            out.println("Person wasn't added: " + person);

    }

    /**
     * print header to the screen
     */
    private static void printHeader(String header) {
        out.println("\r\n----------------------------- " + header + " --------------------------------\r\n");
    }

    /**
     * print small header to the screen
     */
    private static void printSmallHeader(String header) {
        out.println("\r\n--- " + header + " ---");
    }

    /**
     * print small header separator
     */
    private static void printEndSmallHeader() {
        out.println("----------\r\n");
    }

    /**
     * print the oldest person to the screen
     */
    private static void printOldestPersonName(String message, Group group) {
        Person person = group.oldestPerson();
        out.println(message + (person == null ? "Group is empty, null was returned." : person.getFirstName() + " " + person.getLastName()));
    }
}
