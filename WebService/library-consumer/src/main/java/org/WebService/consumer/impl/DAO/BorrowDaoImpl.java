package org.WebService.consumer.impl.DAO;

import org.WebService.consumer.contract.DAO.BorrowDAO;
import org.WebService.consumer.impl.RowMapper.BorrowRM;
import org.WebService.model.Book;
import org.WebService.model.Borrow;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import java.sql.Types;
import java.util.List;

public class BorrowDaoImpl extends AbstractDaoImpl implements BorrowDAO {

    @Inject
    private BorrowRM borrowRM;

    public BorrowRM getBorrowRM() {
        return borrowRM;
    }

    public void setBorrowRM(BorrowRM borrowRM) {
        this.borrowRM = borrowRM;
    }

    @Override
    public void create(Borrow borrow) {

        String vSQL = "INSERT INTO public.borrow (isbn, email, startdate, enddate, isborrowed, isextended) " +
                "VALUES(:isbn, :email, :startdate, :enddate, :isborrowed, :isextended)";



        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("isbn", borrow.getISBN(), Types.INTEGER);
        vParams.addValue("email", borrow.getEmail(), Types.VARCHAR);
        vParams.addValue("startDate", borrow.getStartDate(), Types.DATE);
        vParams.addValue("endDate", borrow.getEndDate(), Types.DATE);
        vParams.addValue("isBorrowed", borrow.isBorrowed(), Types.BOOLEAN);
        vParams.addValue("isExtended", borrow.isExtended(), Types.BOOLEAN);


        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }



    @Override
    public void update(Borrow borrow) {

        String vSQL = "UPDATE public.borrow " +
                "SET email=:email, isbn=:isbn, startdate=:startDate, enddate=:endDate, isborrowed=:isBorrowed, isextended=:isExtended " +
                "WHERE id=:id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();

        vParams.addValue("id", borrow.getId(), Types.INTEGER);
        vParams.addValue("isbn", borrow.getISBN(), Types.INTEGER);
        vParams.addValue("email", borrow.getEmail(), Types.VARCHAR);
        vParams.addValue("startDate", borrow.getStartDate(), Types.DATE);
        vParams.addValue("endDate", borrow.getEndDate(), Types.DATE);
        vParams.addValue("isBorrowed", borrow.isBorrowed(), Types.BOOLEAN);
        vParams.addValue("isExtended", borrow.isExtended(), Types.BOOLEAN);


        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);


    }



    @Override
    public void markAsExtended(Borrow borrow) {

        borrow.setExtended(true);

    }

    @Override
    public List<Borrow> getLateReturns() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String sql = "SELECT * FROM borrow WHERE borrow.enddate < NOW()";

        return vJdbcTemplate.query(sql,borrowRM);
    }

    @Override
    public List<Borrow> getByUserEmail(String email) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String var = "'"+email+"'";
        String vSQL = "SELECT * FROM borrow WHERE email = "+var;

        try {
            return vJdbcTemplate.query(vSQL,borrowRM);
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }
    }


    @Override
    public List<Borrow> getListBorrows() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String sql = "SELECT * FROM borrow";

        return vJdbcTemplate.query(sql,borrowRM);
    }

    @Override
    public Borrow getClosestBorrow(Integer isbn) {

        String vSQL = "select * from borrow where isbn=:isbn order by enddate asc fetch first 1 rows only";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("isbn", isbn);
        try {
            return vJdbcTemplate.queryForObject(vSQL, vParams, borrowRM);
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }
    }

    @Override
    public List<Borrow> sendMailReminder() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String sql = "select * from borrow JOIN useraccount on borrow.email = useraccount.email " +
                "where useraccount.reminder = true and (select date_part('day',age(borrow.enddate,now()))) = 4";

        return vJdbcTemplate.query(sql,borrowRM);
    }

    @Override
    public List<Borrow> getBorrowByBook(String title) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String vSQL = "SELECT * from public.borrow join public.book " +
                "on borrow.ISBN = book.ISBN " +
                "where book.title ="+title;

        try {
            return vJdbcTemplate.query(vSQL,borrowRM);
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }
    }

    @Override
    public Borrow getBorrowById(int id) {
        String vSQL = "SELECT * FROM public.borrow WHERE id = :id";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            return vJdbcTemplate.queryForObject(vSQL, vParams, borrowRM);
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }
    }


}
