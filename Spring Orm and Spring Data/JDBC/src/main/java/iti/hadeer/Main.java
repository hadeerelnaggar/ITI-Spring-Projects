package iti.hadeer;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao = applicationContext.getBean("userDao", UserDaoImpl.class);
        JDBCUserDao jdbcUserDao = applicationContext.getBean("jdbcUserDao",JDBCUserDao.class);
        try {
            User user = userDao.getUserByName("hadeer");
            System.out.println(user);
            User user1 = jdbcUserDao.getUserByName("hadeer");
            System.out.println(user1);
            jdbcUserDao.insertUser("ss", "aa", "ss");
        } finally {
            AbandonedConnectionCleanupThread.checkedShutdown();
        }
        applicationContext.close();
    }

}
