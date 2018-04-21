package org.WebService.consumer.impl.RowMapper;

import org.WebService.model.Borrow;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowRM implements RowMapper<Borrow> {

    @Override
    public Borrow mapRow(ResultSet rs, int i) throws SQLException {

        Borrow borrow = new Borrow();

        borrow.setId(rs.getInt("id"));
        borrow.setEmail(rs.getString("email"));
        borrow.setISBN(rs.getInt("ISBN"));
        borrow.setStartDate(rs.getDate("startDate"));
        borrow.setEndDate(rs.getDate("endDate"));
        borrow.setBorrowed(rs.getBoolean("isBorrowed"));
        borrow.setExtended(rs.getBoolean("isExtended"));


        return borrow;
    }
}
