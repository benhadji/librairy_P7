package org.WebService.business.impl.manager;

import org.WebService.business.contract.manager.AuthorManager;
import org.WebService.model.Author;

import java.util.List;

public class AuthorManagerImpl extends AbstractManagerImpl implements AuthorManager{


    @Override
    public List<Author> getByName(String name) {
        return getDaoFactory().getAuthorDAO().getByName(name);
    }

    @Override
    public void createAuthor(Author author) {
        getDaoFactory().getAuthorDAO().create(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return getDaoFactory().getAuthorDAO().getAllAuthors();
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
