package iti.hadeer.springAop;

import org.springframework.aop.ThrowsAdvice;

public class CalculatorAfterThrow implements ThrowsAdvice{
    public void afterThrowing(IllegalArgumentException e){
        System.out.println(e.getMessage());
    }
}
