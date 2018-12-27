package org.WebService.consumer.impl.DAO;

import org.WebService.consumer.contract.DAO.ReservationDAO;
import org.WebService.consumer.impl.RowMapper.ReservationRM;
import org.WebService.model.Book;
import org.WebService.model.Reservation;
import org.WebService.model.UserAccount;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;


import javax.inject.Inject;
import java.sql.Types;
import java.util.Date;
import java.util.List;

public class ReservationDaoImpl extends AbstractDaoImpl implements ReservationDAO {

    @Inject
    private ReservationRM reservationRM;

    public ReservationRM getReservationRM() {
        return reservationRM;
    }

    public void setReservationRM(ReservationRM reservationRM) {
        this.reservationRM = reservationRM;
    }


    @Override
    public void addReservation(Reservation reservation) {

        String vSQL = "INSERT INTO reservation (isbn, email, reservationdate, position, sendmaildate, closest) " +
                "VALUES(:isbn, :email, :reservationdate, :position, :sendmaildate, :closest)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("isbn", reservation.getISBN(), Types.INTEGER);
        vParams.addValue("email", reservation.getEmail(), Types.VARCHAR);
        vParams.addValue("reservationdate", reservation.getReservationDate(), Types.DATE);
        vParams.addValue("position", reservation.getPosition(), Types.INTEGER);
        vParams.addValue("sendmaildate", null, Types.DATE);
        vParams.addValue("closest", null, Types.DATE);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }



    @Override
    public void updateReservation(Reservation reservation) {

        String vSQL = "UPDATE public.reservation " +
                "SET isbn=:isbn, email=:email, reservationdate=:reservationdate, position=:position, sendmaildate=:sendmaildate, closest=:closest " +
                "WHERE id=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("id", reservation.getId(), Types.INTEGER);
        vParams.addValue("isbn", reservation.getISBN(), Types.INTEGER);
        vParams.addValue("email", reservation.getEmail(), Types.VARCHAR);
        vParams.addValue("reservationdate", reservation.getReservationDate(), Types.DATE);
        vParams.addValue("position", reservation.getPosition(), Types.INTEGER);
        vParams.addValue("sendmaildate", reservation.getSendMailDate(), Types.DATE);
        vParams.addValue("closest", reservation.getClosest(), Types.DATE);


        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }


    @Override
    public void deleteReservation(Reservation reservation) {

        String vSQL = "DELETE FROM public.reservation WHERE id=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", reservation.getId(), Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }

    @Override
    public Reservation getResaById(Integer id) {

        String vSQL = "SELECT * FROM public.reservation WHERE reservation.id = :id";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Reservation reservation = vJdbcTemplate.queryForObject(vSQL, vParams, reservationRM);
            return reservation;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }
    }

    @Override
    public List<Reservation> getAllReservations() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String sql = "SELECT * FROM reservation";

        return vJdbcTemplate.query(sql,reservationRM);
    }

    @Override
    public List<Reservation> getReservationJobTicket1() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String sql = "select * from reservation " +
                "LEFT JOIN book b on reservation.isbn = b.isbn " +
                "where b.copierestant>0 " +
                "and reservation.position=1";

        return vJdbcTemplate.query(sql,reservationRM);
    }


    @Override
    public List<Reservation> listResaByBook(Book book) {


        String vSQL = "SELECT reservation.* FROM public.reservation JOIN public.book " +
                "ON reservation.ISBN = book.ISBN WHERE book.title = :title";

        SqlParameterSource vParams = new BeanPropertySqlParameterSource(book);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.query(vSQL,vParams,reservationRM);
    }

    @Override
    public List<Reservation> listResaByUser(UserAccount utilisateur) {


        String vSQL = "SELECT reservation.* FROM public.reservation JOIN public.useraccount " +
                "ON reservation.email = useraccount.email WHERE useraccount.email = :email";

        SqlParameterSource vParams = new BeanPropertySqlParameterSource(utilisateur);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.query(vSQL,vParams,reservationRM);
    }



}
