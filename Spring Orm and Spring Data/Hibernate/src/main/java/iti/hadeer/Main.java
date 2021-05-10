package iti.hadeer;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String args[]) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        try{
        UserDaoImpl userDao = context.getBean("userDao", UserDaoImpl.class);
        UserDao userDao1 = (UserDao)context.getBean("userDao1");
        UserDao userDao2 = context.getBean("userDao2", UserDaoImpl2.class);
        for (User user : userDao.findAll()) {
            System.out.println(user);
        }
        System.out.println("-------------------------------------------------------");
        for (User user : userDao1.findAll()) {
            System.out.println(user);
        }
        User user = new User();
        user.setFirstName("jjj");
        user.setLastName("aaa");
        user.setMiddleName("middleName");
        userDao1.saveUser(user);
    }finally{
        AbandonedConnectionCleanupThread.checkedShutdown();
    }
    context.close();
    }

}
