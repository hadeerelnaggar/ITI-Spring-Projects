package iti.hadeer;

public class FirstClass {
    SecondClass secondClass;

    public FirstClass(){

    }
    public FirstClass(SecondClass secondClass) {
        this.secondClass = secondClass;
    }

    public void setSecondClass(SecondClass secondClass) {
        this.secondClass = secondClass;
    }

}
