package rvt;

public class Person {
    private String name;
    private String address;
    public Person(String name, String adress) {
        this.name = name;
        this.address = adress;
    }
    public String getName() {
        return this.name;
    }
    public String getAdress() {
        return this.address;
    }
    @Override
    public String toString() {
        return this.name + "\n" + this.address;
    }
}
