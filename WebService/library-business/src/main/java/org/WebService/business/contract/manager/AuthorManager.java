package org.WebService.business.contract.manager;


import org.WebService.model.Author;

import java.util.List;

public interface AuthorManager {

    List<Author> getByName(String name);
    void createAuthor(Author author);
    List<Author> getAllAuthors();
    Author getById(Integer id);
    Author getAuthorByBookTitle(String title);




}
