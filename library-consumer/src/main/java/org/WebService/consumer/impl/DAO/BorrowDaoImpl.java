package org.WebService.consumer.impl.DAO;

import org.WebService.consumer.contract.DAO.BorrowDAO;
import org.WebService.consumer.impl.RowMapper.BorrowRM;
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

        List<Borrow> borrows = vJdbcTemplate.query(sql,borrowRM);
        return borrows;
    }

    @Override
    public List<Borrow> getByUserEmail(String email) {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String var = "'"+email+"'";
        String vSQL = "SELECT * FROM borrow WHERE email = "+var;

        try {
            List<Borrow> borrows = vJdbcTemplate.query(vSQL,borrowRM);
            return borrows;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }
    }


    @Override
    public List<Borrow> getListBorrows() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String sql = "SELECT * FROM borrow";

        List<Borrow> borrows = vJdbcTemplate.query(sql,borrowRM);
        return borrows;
    }
}
