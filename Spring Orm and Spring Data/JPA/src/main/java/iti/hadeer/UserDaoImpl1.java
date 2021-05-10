package iti.hadeer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class UserDaoImpl1 implements UserDao{

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        this.hibernateTemplate = hibernateTemplate;
    }
    @Override
    public long count() {
        String query = "select count(u) from User u";
        List result = hibernateTemplate.find(query,Long.class);
        return (long)result.get(0);
    }

    @Override
    public List<User> findAll() {
        String query = "from User u";
        return (List<User>) hibernateTemplate.find(query,null);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        hibernateTemplate.saveOrUpdate(user);
    }
    
}
