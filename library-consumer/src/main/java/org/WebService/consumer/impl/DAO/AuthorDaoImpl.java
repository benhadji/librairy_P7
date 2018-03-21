package org.WebService.consumer.impl.DAO;

import org.WebService.consumer.contract.DAO.AuthorDAO;
import org.WebService.consumer.impl.RowMapper.AuthorRM;
import org.WebService.model.Author;
import org.WebService.model.Book;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.inject.Inject;
import java.sql.Types;
import java.util.List;

public class AuthorDaoImpl extends AbstractDaoImpl implements AuthorDAO {

    @Inject
    private AuthorRM authorRM;

    public AuthorRM getAuthorRM() {
        return authorRM;
    }

    public void setAuthorRM(AuthorRM authorRM) {
        this.authorRM = authorRM;
    }

    @Override
    public void create(Author author) {

        String vSQL = "INSERT INTO public.author (firstname, lastname) VALUES(:firstName, :lastName)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("firstName", author.getFirstName(), Types.VARCHAR);
        vParams.addValue("lastName", author.getLastName(), Types.VARCHAR);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }

    @Override
    public Author getById(Integer id) {
        String vSQL = "SELECT * FROM public.author WHERE id=:id";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("id", id);
        try {
            Author author = vJdbcTemplate.queryForObject(vSQL, vParams, authorRM);
            return author;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }

    }


    @Override
    public List<Author> getAllAuthors() {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String sql = "SELECT * FROM author";

        return vJdbcTemplate.query(sql,authorRM);
    }

    @Override
    public List<Author> getByName(String name) {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String var = "'"+name+"'";
        String vSQL = "SELECT * FROM author WHERE firstname = "+var;

        try {
            List<Author> authors = vJdbcTemplate.query(vSQL,authorRM);
            return authors;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }
    }


}
