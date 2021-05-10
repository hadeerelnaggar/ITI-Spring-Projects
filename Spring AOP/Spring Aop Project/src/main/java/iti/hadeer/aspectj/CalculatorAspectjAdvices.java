package iti.hadeer.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorAspectjAdvices {
    
    @Before("Pointcuts.anyMethod()")
    public void before(JoinPoint joinPoint){
        System.out.println("Before "+joinPoint.getSignature().getName());
    }

    @After("Pointcuts.calculatorAdd()")
    public void after(JoinPoint joinPoint){
        System.out.println("After "+joinPoint.getSignature().getName());
    }

    @AfterReturning(returning = "result", pointcut = "Pointcuts.calculatorAdd()")
    public void afterReturning(JoinPoint joinPoint, Object result){
        System.out.println("result is "+result);
    }    
}
