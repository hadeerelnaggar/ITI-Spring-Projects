package iti.hadeer;

public class ServiceFactory {
    public ServiceInterface createService(ServiceInterface service){
        System.out.println("create in factory class");
        return service;
    }
}
