package org.WebService.consumer.impl.RowMapper;

import org.WebService.model.Reservation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationRM implements RowMapper<Reservation> {
    @Override
    public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {

        Reservation reservation = new Reservation();

        reservation.setId(rs.getInt("id"));
        reservation.setEmail(rs.getString("email"));
        reservation.setISBN(rs.getInt("ISBN"));
        reservation.setPosition(rs.getInt("position"));
        reservation.setReservationDate(rs.getDate("reservationDate"));


        return reservation;
    }
}
