package iti.hadeer;

public class CalculatorAdvice {
    
    public void before(double firstNumber, String operator, double secondNumber){
        System.out.println(firstNumber+" "+operator+" "+secondNumber);
    }

    public void after(double result){
        System.out.println("result is "+result);
    }

    public void afterThrowing(Exception e){
        System.out.println(e.getMessage());
    }
}
