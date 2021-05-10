package iti.hadeer.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class blaImpl {
    
    @PostConstruct
    public void init(){
        System.out.println("From blaImpl init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("From blaImpl destroy");
    }
}
