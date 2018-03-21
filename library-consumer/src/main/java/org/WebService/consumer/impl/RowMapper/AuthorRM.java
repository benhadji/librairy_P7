package org.WebService.consumer.impl.RowMapper;

import org.WebService.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRM implements RowMapper<Author> {

    @Override
    public Author mapRow(ResultSet resultSet, int i) throws SQLException {

        Author author = new Author();

        author.setId(resultSet.getInt("id"));
        author.setFirstName(resultSet.getString("firstName"));
        author.setLastName(resultSet.getString("lastName"));

        return author;

    }
}
