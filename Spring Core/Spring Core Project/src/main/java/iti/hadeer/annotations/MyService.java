package iti.hadeer.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("myService")
@Scope("prototype")
public class MyService {
    @PostConstruct
    public void init(){
        System.out.println("From MyService init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("From MyService destroy");
    }
}
