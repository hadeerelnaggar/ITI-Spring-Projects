package iti.hadeer.general;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class AbstractProxy implements InvocationHandler{

    Object target;
    GeneralAdvice advice;

    public AbstractProxy(Object target) {
        this.target = target;
        this.advice = new GeneralAdvice();
    }

    public static Object newInstance(Object obj){
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new AbstractProxy(obj));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try{
            advice.before(args);
            result = method.invoke(target, args);
        }catch(Exception e){
            advice.afterThrowing(e);
        }
        advice.after(result);
        return result;
    }
    
}
