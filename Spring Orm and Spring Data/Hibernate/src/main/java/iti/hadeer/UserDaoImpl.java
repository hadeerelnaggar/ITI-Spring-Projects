package iti.hadeer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDaoImpl implements UserDao{
    private Session session;

    public void setSessionFactory(SessionFactory sessionFactory){
        session = sessionFactory.openSession();
    }

    public long count(){
        String query = "select count(*) from users";
        return (long)session.createQuery(query).uniqueResult();
    }

    public List<User> findAll(){
        return session.createQuery("from User u").list();
    }

    public void saveUser(User user){
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }
    
}
