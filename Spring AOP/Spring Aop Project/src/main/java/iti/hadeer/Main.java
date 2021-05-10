package iti.hadeer;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iti.hadeer.general.AbstractProxy;
import iti.hadeer.introduction.MaxCalculator;

public class Main {

    public static void main(String []args) {
        // CalculatorFactory calculatorFactory = new CalculatorFactory();
        // Calculator calculator = calculatorFactory.getTargeCalculator();
        // calculator.add(22, 30);

        // calculator = new CalculatorImpl();
        // Calculator calculator2 = (Calculator)AbstractProxy.newInstance(calculator);
        // calculator2.add(33, 88);

        // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        // Calculator calc = applicationContext.getBean("proxyFactory",Calculator.class);
        // calc.add(33, 11);
        // calc.subtract(20, 10);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("day2.xml");
        Calculator calc = applicationContext.getBean("calc",Calculator.class);
        calc.add(33, 11);
        calc.subtract(20, 10);
        MaxCalculator maxCalculator = (MaxCalculator) calc;
        maxCalculator.max(33, 11);
    }
    
}
