package rvt;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Person
        Person ada = new Person("Ada Lovelace", "24 Maddox St. London W1S 2QN");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie 15 00100 Helsinki");
        System.out.println(ada);
        System.out.println(esko);

        // Student
        Student ollie = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
        System.out.println(ollie);
        System.out.println("Study credits " + ollie.credits());
        ollie.study();
        System.out.println("Study credits " + ollie.credits());

        // Student's toString override demonstration
        Student ollie2 = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
        System.out.println(ollie2);
        ollie2.study();
        System.out.println(ollie2);

        // Teacher
        Teacher adaT = new Teacher("Ada Lovelace", "24 Maddox St. London W1S 2QN", 1200);
        Teacher eskoT = new Teacher("Esko Ukkonen", "Mannerheimintie 15 00100 Helsinki", 5400);
        System.out.println(adaT);
        System.out.println(eskoT);

        Student ollie3 = new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028");
        int i = 0;
        while (i < 25) {
            ollie3.study();
            i = i + 1;
        }
        System.out.println(ollie3);

        // printPersons
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Teacher("Ada Lovelace", "24 Maddox St. London W1S 2QN", 1200));
        persons.add(new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028"));
        printPersons(persons);
    }

    public static void printPersons(ArrayList<Person> persons) {
        for (Person p : persons) {
            System.out.println(p);
        }
    }
}
