package com.maman11;

public class Driver {
    public static void main(String[] args) {
        Group group = new Group();

        group.addPerson(new Person("Shay", "Vaturi", 1, 28, 9, 1982));
        group.addPerson(new Person("Tzipi", "Shavit", 99, 28, 9, 1982));
        group.addPerson(new Person("Dudu", "Zar", 55, 29, 9, 1982));
        group.addPerson(new Person("Uzi", "Hitman", 66, 28, 10, 1982));
        group.addPerson(new Person("Yossi", "Cohen", 2, 3, 10, 1970));
        group.addPerson(new Person("Moshe", "Sagee", 3, 2, 10, 1970));
        group.addPerson(new Person("Yossi", "Cohen", 2, 3, 10, 1970));

        System.out.printf(group.toString());

        System.out.println("Born in date 28/9/1982: " + group.bornInDate(new Date(28, 9, 1982)));
        System.out.println("Born in month 10: " + group.bornInMonth(10));
        System.out.println("Oldest person: " + group.oldestPerson());
    }
}
