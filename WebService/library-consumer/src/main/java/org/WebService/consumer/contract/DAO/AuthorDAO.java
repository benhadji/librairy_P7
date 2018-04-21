package org.WebService.consumer.contract.DAO;

import org.WebService.model.Author;
import org.WebService.model.Book;

import java.util.List;

public interface AuthorDAO {

    void create(Author author);
    Author getById(Integer id);
    List<Author> getAllAuthors();
    List<Author> getByName(String name);


}
