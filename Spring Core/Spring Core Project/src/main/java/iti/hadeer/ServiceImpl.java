package iti.hadeer;



public class ServiceImpl implements ServiceInterface{

    String x;
    public ServiceImpl(){
        System.out.println("Service Impl default constructor");
    }
    public ServiceImpl(int x){
        System.out.println("Service Impl int arg constructor "+x);
    }

    public ServiceImpl(String x){
        this.x = x;
        System.out.println("Service Impl string arg constructor "+x);
    }

    public ServiceImpl(String x,String y){
        System.out.println("Service Impl string 2 arg constructor "+x+" "+y);
    }

    @Override
    public void doSomething() {
        System.out.println("From do something method");        
    }

    public void init(){
        System.out.println("init()");
    }

    public void shutdown(){
        System.out.println("close");
    }
    
}
