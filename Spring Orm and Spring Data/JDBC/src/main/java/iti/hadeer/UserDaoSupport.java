package iti.hadeer;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class UserDaoSupport extends JdbcDaoSupport implements UserDao{


    @Override
    public User getUserByName(String name) {
        String sql = "select * from users where firstname = ?";
        Object[]args = new Object[]{name};
        // SqlRowSet rowSet =  jdbcTemplate.queryForRowSet(sql, args);
        // User user = new User();
        // if(rowSet.next()){
        //     user.setFirstname(rowSet.getString("firstname"));
        //     user.setMiddlename(rowSet.getString("middlename"));
        //     user.setLastname(rowSet.getString("lastname"));
        // }
        // return user;

        return (User)getJdbcTemplate().queryForObject(sql, args,new User());
    }

    @Override
    public int count() {
        String sql = "select count(*) from users";
        return getJdbcTemplate().queryForObject(sql, Integer.class);
    }
}
