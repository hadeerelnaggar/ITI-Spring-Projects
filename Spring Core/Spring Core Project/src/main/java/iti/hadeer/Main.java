package iti.hadeer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iti.hadeer.annotations.MyRepo;
import iti.hadeer.annotations.MyService;

public class Main {
    public static void main(String[] args) {
        // ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("testing");
        context.register(AppConfig.class);
        context.register(TestConfig.class);
        context.refresh();
        // context.getBean("serviceUser", ServiceUser.class);
        // ConfigurableApplicationContext context = new
        // ClassPathXmlApplicationContext("annotationsbeans.xml");
        // context.getBean("scopeTest2",ScopesTest.class);
        // context.getBean("objWithList",ScopesTest.class).printList();

        // ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        // Student student = context.getBean("student",Student.class);
        // System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+student.name+"
        // "+student.age);

        // Student student1 = context.getBean("student1",Student.class);
        // System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+student1.name+"
        // "+student1.age);

        // ScopesTest scopesTest = context.getBean("listTest",ScopesTest.class);
        // scopesTest.printList();

        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("annotationsbeans.xml");

        // context.getBean("myService",MyService.class);
        // context.getBean("myRepo",MyRepo.class);
        // context.registerShutdownHook();
        // context.close();

        // ServiceInterface service =
        // context.getBean("service1",ServiceInterface.class);
        // service.doSomething();
    }

}
