package rvt;

public class Student extends Person{
    private int credits;
    public Student(String name, String adress) {
        super(name, adress); // Person(name, adress);
    }

    public int study() {
        return credits += 1;
    }

    public String toString() {
        return super.toString() + "\n  Study credits: " + this.credits;
    }
}
