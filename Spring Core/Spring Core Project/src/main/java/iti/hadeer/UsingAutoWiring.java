package iti.hadeer;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UsingAutoWiring {
    // @Resource(name = "test2")
    // @Qualifier("test2")
    @Autowired(required = true)
    @MyQualifier(name = "testt",number = "20")
    ServiceImpl serviceInterface;

    public UsingAutoWiring() {
        System.out.println("Default constructor");
    }

    public UsingAutoWiring(ServiceImpl serviceInterface) {
        System.out.println("arg constructor");
        this.serviceInterface = serviceInterface;
    }

    // @Autowired(required = true)
    // @Qualifier("test2")
    public void setSeviceInterface(ServiceImpl serviceInterface) {
        System.out.println("Setter");
        this.serviceInterface = serviceInterface;
    }

}
