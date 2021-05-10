package iti.hadeer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    // public void setEntityManagerFactory (EntityManagerFactory entityManagerFactory){
    //     entityManager = entityManagerFactory.createEntityManager();
    // }

    public long count(){
        String query = "select count(*) from users";
        return (long)entityManager.createQuery(query).getSingleResult();
    }

    public List<User> findAll(){
        return entityManager.createQuery("from User u").getResultList();
    }

    @Transactional
    public void saveUser(User user){
        entityManager.persist(user);
    }
    
}
