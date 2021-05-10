package iti.hadeer;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class JDBCUserDao implements UserDao{

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("users").usingColumns("firstname","middlename","lastname").usingGeneratedKeyColumns("id");
    }

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

        return (User)jdbcTemplate.queryForObject(sql, args,new User());
    }

    @Override
    public int count() {
        String sql = "select count(*) from users";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public void insertUser(String firstName, String middleName, String lastName){
        // Map<String,Object> parameters = new HashMap<>();
        // parameters.put("firstname", firstName);
        // parameters.put("lastname", lastName);
        // parameters.put("middlename", middleName);
        User user = new User();
        user.setFirstname(firstName);
        user.setMiddlename(middleName);
        user.setLastname(lastName);
        SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
        simpleJdbcInsert.execute(parameters);

    }
    
}
