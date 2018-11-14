package org.WebService.consumer.impl.DAO;

import org.WebService.consumer.contract.DAO.BookDAO;
import org.WebService.consumer.impl.RowMapper.BookRM;
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

public class BookDaoImpl extends AbstractDaoImpl implements BookDAO {

    @Inject
    private BookRM bookRM;

    public BookRM getBookRM() {
        return bookRM;
    }

    public void setBookRM(BookRM bookRM) {
        this.bookRM = bookRM;
    }

    @Override
    public void create(Book book) {
        String vSQL = "INSERT INTO public.book (isbn, editor_id, author_id, title, year, nbofcopy) VALUES(:isbn, :editor_id, :author_id, :title, :year, :nbofcopy)";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("isbn", book.getISBN(), Types.INTEGER);
        vParams.addValue("editor_id", book.getEditor_id(), Types.INTEGER);
        vParams.addValue("author_id", book.getAuthor_id(), Types.INTEGER);
        vParams.addValue("title", book.getTitle(), Types.VARCHAR);
        vParams.addValue("year", book.getYear(), Types.INTEGER);
        vParams.addValue("nbOfCopy", book.getNbOfCopy(), Types.INTEGER);

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

    }

    @Override
    public Book getById(Integer isbn) {
        String vSQL = "SELECT * FROM public.book WHERE book.isbn = :isbn";
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource vParams = new MapSqlParameterSource("isbn", isbn);
        try {
            Book book = vJdbcTemplate.queryForObject(vSQL, vParams, bookRM);
            return book;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }
    }


    @Override
    public List<Book> getAllBooks() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String sql = "SELECT * FROM book";
        List<Book> vList = vJdbcTemplate.query(sql,bookRM);
        return vList;
    }

    @Override
    public List<Book> getByName(String name) {

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        String var = "'"+name+"'";
        String vSQL = "SELECT * FROM book WHERE title = "+var;

        try {
            List<Book> books = vJdbcTemplate.query(vSQL,bookRM);
            return books;
        } catch (EmptyResultDataAccessException vEx) {
            return null;
        }
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {

        String vSQL = "SELECT book.* FROM public.book JOIN public.author " +
                "ON book.author_id = author.id WHERE author.firstname = :firstName";

        SqlParameterSource vParams = new BeanPropertySqlParameterSource(author);
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.query(vSQL,vParams,bookRM);
    }
}
