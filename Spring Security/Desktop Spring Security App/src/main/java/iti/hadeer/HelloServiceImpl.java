package iti.hadeer;

import java.util.ArrayList;
import java.util.List;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello ya " + name;
    }

    @Override
    public String sayHi(String name) {
        return "Hi" + name;
    }

    @Override
    public void sayMyName(String name) {
        System.out.println(name);
    }

    @Override
    public User confirm(User user) {
        System.out.println("Confirm");
        return user;
    }

    @Override
    public List<User> getAllUsers(User user) {
        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }

}
