package org.WebService.consumer.impl.RowMapper;

import org.WebService.model.UserAccount;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountRM implements RowMapper<UserAccount> {

    @Override
    public UserAccount mapRow(ResultSet resultSet, int i) throws SQLException {

        UserAccount user = new UserAccount();

        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setFirstName(resultSet.getString("firstName"));
        user.setLastName(resultSet.getString("lastName"));
        user.setAddress(resultSet.getString("address"));
        user.setCity(resultSet.getString("city"));
        user.setPostCode(resultSet.getInt("postCode"));
        user.setPhoneNumber(resultSet.getString("phoneNumber"));
        user.setReminder(resultSet.getBoolean("reminder"));


        return user;
    }
}
