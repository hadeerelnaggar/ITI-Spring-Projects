package iti.hadeer.springAop;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CalculatorAround implements MethodInterceptor{

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        System.out.println(arg1.getName());
        Object result = null;
        try{
            result = arg3.invoke(arg0, arg2);
        }
        catch(IllegalArgumentException e){
            e.printStackTrace();
            throw e;
        }
        return result;
    }
    
}
