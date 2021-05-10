package iti.hadeer.introduction;

public class MaxCalculatorImpl implements MaxCalculator{
    public double max(double firstNumber, double secondNumber){
        double result = (firstNumber >= secondNumber)?firstNumber:secondNumber;
        System.out.println("result of max is "+result);
        return result; 
    }
}
