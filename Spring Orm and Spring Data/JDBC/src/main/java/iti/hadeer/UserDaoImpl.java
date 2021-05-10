package iti.hadeer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserDaoImpl implements UserDao{

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    public User getUserByName(String name) {
        String sql = "select * from users where firstname = ?";
        Connection conn = null;
        System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        User user = new User();
        try{
            conn = dataSource.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user.setFirstname(resultSet.getString("firstname"));
            user.setMiddlename(resultSet.getString("middlename"));
            user.setLastname(resultSet.getString("lastname"));
            user.setEmail(resultSet.getString("email"));
            user.setPhone(resultSet.getString("phone"));
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(conn!=null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.getMessage();
                }
            }
        }
        return user;
    }
    @Override
    public int count() {
        String sql = "select count(*) from users";
        return 0;
    }
    
}
