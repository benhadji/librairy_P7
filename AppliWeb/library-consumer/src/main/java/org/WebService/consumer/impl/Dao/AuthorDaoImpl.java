package org.WebService.consumer.impl.Dao;

import org.WebService.consumer.contract.Dao.AuthorDao;
import org.webservice.service.services.Author;
import org.webservice.service.services.AuthorService;
import org.webservice.service.services.Author_Service;


import java.util.List;

public class AuthorDaoImpl implements AuthorDao {

    private Author_Service authorService = new Author_Service();
    private AuthorService authorSrv = authorService.getAuthorServicePort();

    public Author_Service getAuthorService() {
        return authorService;
    }

    public void setAuthorService(Author_Service authorService) {
        this.authorService = authorService;
    }

    public AuthorService getAuthorSrv() {
        return authorSrv;
    }

    public void setAuthorSrv(AuthorService authorSrv) {
        this.authorSrv = authorSrv;
    }


    @Override
    public Author getAuthor(Author author) {
        return null;
    }

    @Override
    public List<Author> getAuthorByName(String name) {
        return authorSrv.getAuthorByName(name);
    }

    @Override
    public Author getAuthorByBookTitle(String title) {
        return authorSrv.getAuthorByBooktitle(title);
    }

    @Override
    public List<Author> listAuthors() {
        return null;
    }

    @Override
    public Author getById(Integer id) {
        return authorSrv.getAuthorById(id);
    }
}
