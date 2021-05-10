package iti.hadeer.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepo {

    @Autowired
    MyService myservice;

    @PostConstruct
    public void init(){
        System.out.println("From MyRepo init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("From MyRepo destroy");
    }
}
