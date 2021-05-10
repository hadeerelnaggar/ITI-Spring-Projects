package iti.hadeer;

public class TestInheritence {
    Person person;
    Student student;

    public TestInheritence(){

    }
    public TestInheritence(Student student){
        System.out.println("Child constructor");
        this.student = student;
    }

    public TestInheritence(Person person){
        System.out.println("Parent constructor");
        this.person = person;
    }

    public TestInheritence(Person person, Student student){
        System.out.println("TestInheritence 2 param constructor");
        this.person = person;
        this.student = student;
    }

    public void setPerson(Person person){
        this.person = person;
    }

    public void setStudent(Student student){
        this.student = student;
    }

    @Override
    public String toString(){
        return person+" "+student;
    }
}
