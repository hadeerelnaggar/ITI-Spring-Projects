package iti.hadeer.general;

public class GeneralAdvice {
    public void before(Object[]args){
        for(Object argument: args){
            System.out.println(argument+" ");
        }
    }

    public void after(Object result){
        System.out.println("result is "+result);
    }

    public void afterThrowing(Exception e){
        System.out.println(e.getMessage());
    }
    
}
