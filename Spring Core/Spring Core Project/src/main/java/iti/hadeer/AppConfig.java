package iti.hadeer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Configuration
@ImportResource("classpath:/annotationsbeans.xml")
@Production
// @Profile("production")
public class AppConfig {
    @Bean
    public Student myStudent(){
        System.out.println("Student function");

        return new Student();
    }

    @Bean
    public ServiceImpl serviceImpl(){
        System.out.println("ServiceImpl function");
        return new ServiceImpl("hadeer");
    }

    @Bean
    // @Scope("prototype")
    public ServiceUser serviceUser(){
        System.out.println("ServiceUser function");
        return new ServiceUser(serviceImpl());
    }

    @Bean
    public ServiceUser serviceUser2(){
        System.out.println("ServiceUser2 function");
        return new ServiceUser(serviceImpl());
    }
}
