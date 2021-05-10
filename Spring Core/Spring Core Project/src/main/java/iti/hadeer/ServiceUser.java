package iti.hadeer;

public class ServiceUser {
    ServiceInterface service;

    public ServiceUser(){
        System.out.println("default Serviceuser Constructor");
    }

    public ServiceUser(ServiceInterface service){
        System.out.println("ServiceUser with ServiceInterface arg constructor");
        this.service = service;
    }

    public ServiceUser(ServiceImpl serviceImpl){
        System.out.println("ServiceUser with ServiceImpl arg constructor");
        this.service = serviceImpl;
    }

    public void setService(ServiceInterface service){
        System.out.println("ServiceUser with ServiceInterface arg setter");
        this.service = service;
    }

    public static ServiceInterface createServiceUser(){
        System.out.println("Factory method");
        return new ServiceImpl();
    }
    
}
