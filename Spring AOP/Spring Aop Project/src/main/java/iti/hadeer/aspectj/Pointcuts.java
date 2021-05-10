package iti.hadeer.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Pointcuts {

    @Pointcut("execution(!private double iti.hadeer..add(..))")
    public void calculatorAdd(){

    }

    @Pointcut("execution(* *(..))")
    public void anyMethod(){

    }

    @Pointcut("execution(* iti.hadeer..subtract(..))")
    public void CalculatorSubtract(){

    }
    
}
