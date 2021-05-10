package iti.hadeer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class CalculatorProxy implements InvocationHandler {

    Calculator target;
    CalculatorAdvice advice;

    public CalculatorProxy(Calculator target, CalculatorAdvice advice) {
        this.target = target;
        this.advice = advice;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        double result = 0;
        double firstNumber = (double) args[0];
        double secondNumber = (double) args[1];
        switch (method.getName()) {
        case "add":
            try {
                advice.before(firstNumber, "+", secondNumber);

                result = target.add(firstNumber, secondNumber);
                advice.after(result);

            } catch (Exception e) {
                advice.afterThrowing(e);
            }
            break;
        case "subtract":
            try {
                advice.before(firstNumber, "-", secondNumber);

                result = target.subtract(firstNumber, secondNumber);
                advice.after(result);

            } catch (Exception e) {
                advice.afterThrowing(e);
            }
            break;

        case "multiply":
            try {
                advice.before(firstNumber, "*", secondNumber);

                result = target.multiply(firstNumber, secondNumber);
                advice.after(result);

            } catch (Exception e) {
                advice.afterThrowing(e);
            }
            break;
        case "divide":
            try {
                advice.before(firstNumber, "/", secondNumber);

                result = target.divide(firstNumber, secondNumber);
                advice.after(result);

            } catch (Exception e) {
                advice.afterThrowing(e);
            }
            break;
        }
        return result;

    }

}
