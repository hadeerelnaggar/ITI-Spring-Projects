package iti.hadeer.introduction;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class CalculatorAspect {
    @DeclareParents(defaultImpl = MaxCalculatorImpl.class, value = "iti.hadeer.CalculatorImpl")
    public MaxCalculator maxCalculator;
}
