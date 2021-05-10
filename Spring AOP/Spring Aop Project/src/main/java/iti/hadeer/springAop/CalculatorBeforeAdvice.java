package iti.hadeer.springAop;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;

public class CalculatorBeforeAdvice implements MethodBeforeAdvice{

    @Override
    public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
        System.out.println(arg0.getName()+Arrays.toString(arg1));        
    }
    
}
