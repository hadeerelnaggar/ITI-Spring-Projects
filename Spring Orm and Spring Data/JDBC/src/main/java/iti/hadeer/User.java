package iti.hadeer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class User implements RowMapper {
    int id;
    String firstname;
    String middlename;
    String lastname;
    String email;
    String phone;

    @Override
    public String toString() {
        return firstname + " " + middlename + " " + lastname;
    }

    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();
        user.setFirstname(resultSet.getString("firstname"));
        user.setMiddlename(resultSet.getString("middlename"));
        user.setLastname(resultSet.getString("lastname"));
        user.setEmail(resultSet.getString("email"));
        user.setPhone(resultSet.getString("phone"));
        return user;
    }
}
