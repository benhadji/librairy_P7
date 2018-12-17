package org.WebService.business.impl.manager;

import org.WebService.business.AbstractManager;
import org.WebService.business.contract.manager.AuthorManager;
import org.webservice.service.services.Author;
import java.util.List;


public class AuthorManagerImpl extends AbstractManager implements AuthorManager {

    @Override
    public Author getAuthor(Author author) {
        return null;
    }

    @Override
    public List<Author> listAuthors() {
        return null;
    }

    @Override
    public List<Author> getAuthorByName(String name) {
        return getDaoFactory().getAuthorDAO().getAuthorByName(name);
    }

    @Override
    public Author getById(Integer id) {
        return getDaoFactory().getAuthorDAO().getById(id);
    }

    @Override
    public Author getAuthorByBookTitle(String title) {
        return getDaoFactory().getAuthorDAO().getAuthorByBookTitle(title);
    }
}
