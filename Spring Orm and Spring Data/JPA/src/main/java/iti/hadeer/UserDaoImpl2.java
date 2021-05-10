package iti.hadeer;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class UserDaoImpl2 implements UserDao {
    private HibernateTemplate hibernateTemplate;
    private TransactionTemplate transactionTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public long count() {
        String query = "select count(u) from User u";
        List result = hibernateTemplate.find(query, Long.class);
        return (long) result.get(0);
    }

    @Override
    public List<User> findAll() {
        String query = "from User u";
        return (List<User>) hibernateTemplate.find(query, null);
    }

    @Override
    public void saveUser(User user) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus ts) {
                hibernateTemplate.save(user);
                return ts;
            }
        });
    }
}
