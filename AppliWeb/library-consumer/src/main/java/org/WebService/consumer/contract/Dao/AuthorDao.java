package org.WebService.consumer.contract.Dao;



import org.webservice.service.services.Author;

import java.util.List;

public interface AuthorDao {

    Author getAuthor(Author author);

    List<Author> listAuthors();

    Author getById(Integer authorId);

    List<Author> getAuthorByName(String name);
}
