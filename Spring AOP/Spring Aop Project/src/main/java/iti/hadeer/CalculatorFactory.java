package iti.hadeer;

import java.lang.reflect.Proxy;

public class CalculatorFactory {
    private final Calculator target;
    private final Calculator targetWithAdvice;

    public CalculatorFactory(){
        target = new CalculatorImpl();
        CalculatorAdvice advice = new CalculatorAdvice();
        CalculatorProxy proxy = new CalculatorProxy(target, advice);

        Class[] interfaces = new Class[]{Calculator.class};
        targetWithAdvice = (Calculator)Proxy.newProxyInstance(proxy.getClass().getClassLoader(), interfaces, proxy);

    }
    
    public Calculator getTargeCalculator(){
        return targetWithAdvice;
    }
}
