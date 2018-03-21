package org.WebService.service.services;

import org.WebService.model.Author;
import org.WebService.service.AbstractService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "Author")
public class AuthorService extends AbstractService {

    @WebMethod
    public List<Author> getAuthorByName(String name) {
        return getManagerFactory().getAuthorManager().getByName(name);
    }

    @WebMethod
    public List<Author> listAuthors() {
        return getManagerFactory().getAuthorManager().getAllAuthors();
    }

    @WebMethod
    public void createAuthor(Author author){
        getManagerFactory().getAuthorManager().createAuthor(author);
    }

    @WebMethod
    public Author getAuthorById(Integer id) {
        return getManagerFactory().getAuthorManager().getById(id);
    }



}
