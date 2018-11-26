package org.WebService.consumer.impl.RowMapper;

import org.WebService.model.Book;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRM implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {

        Book book = new Book();

        book.setISBN(resultSet.getInt("ISBN"));
        book.setTitle(resultSet.getString("title"));
        book.setYear(resultSet.getInt("year"));
        book.setNbOfCopy(resultSet.getInt("nbOfCopy"));
        book.setCopieRestant(resultSet.getInt("copieRestant"));
        book.setAuthor_id(resultSet.getInt("author_id"));
        book.setEditor_id(resultSet.getInt("editor_id"));


        return book;
    }
}
