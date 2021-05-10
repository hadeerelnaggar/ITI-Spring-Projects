package iti.hadeer;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;


public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        try {
            UserDao userDao = (UserDao) context.getBean("userDao");
            // User user = new User(100, "firstName", "middleName", "lastName", "email", "01206968970");
            // userDao.save(user);
            // userDao.deleteById(16);
            Iterable<User> users = userDao.findAll(PageRequest.of(0, 3));
            System.out.println("-----------------------------------------------");
            for (User user : users) {
                System.out.println(user);
            }
            System.out.println("-----------------------------------------------");
            System.out.println(userDao.countByFirstName("hadeer"));
            Iterable<User> users1 = userDao.findUsersByIdLessThan(4);
            System.out.println("-----------------------------------------------");
            for (User user : users1) {
                System.out.println(user);
            }
            System.out.println("-----------------------------------------------");
            //gives exception as result is not unique
            // System.out.println(userDao.findUserByLastNameIgnoreCase("ss"));
            System.out.println(userDao.findUserByLastNameIgnoreCase("elnaggar"));
            System.out.println("-----------------------------------------------");
            System.out.println(userDao.findUserByNames("firstName", "lastName"));

        } finally {
            AbandonedConnectionCleanupThread.checkedShutdown();
        }
        context.close();
    }
}
