package iti.hadeer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator{

    @Override
    public double add(double firstNumber, double secondNumber) {
        return firstNumber+secondNumber;
    }

    @Override
    public double subtract(double firstNumber, double secondNumber) {
        return firstNumber-secondNumber;
    }

    @Override
    public double multiply(double firstNumber, double secondNumber) {
        return firstNumber*secondNumber;
    }

    @Override
    public double divide(double firstNumber, double secondNumber) {
        return firstNumber/secondNumber;
    }
    
    // @Bean(name = "calc")
    // public Calculator calc(){
    //     return new CalculatorImpl();
    // }
}
