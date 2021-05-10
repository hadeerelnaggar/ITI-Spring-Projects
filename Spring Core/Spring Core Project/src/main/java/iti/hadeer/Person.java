package iti.hadeer;

public class Person {
    String name;

    public Person() {
        System.out.println("Person Default constructor");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
