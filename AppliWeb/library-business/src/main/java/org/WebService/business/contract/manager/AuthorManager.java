package org.WebService.business.contract.manager;





import org.webservice.service.services.Author;

import java.util.List;

public interface AuthorManager {

    Author getAuthor(Author author);
    List<Author> listAuthors();
    List<Author> getAuthorByName(String name);
    Author getById(Integer id);
    Author getAuthorByBookTitle(String title);

}
