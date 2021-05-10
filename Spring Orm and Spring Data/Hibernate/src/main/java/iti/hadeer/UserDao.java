package iti.hadeer;

import java.util.List;

public interface UserDao {
    public long count();

    public List<User> findAll();

    public void saveUser(User user);
    
}
