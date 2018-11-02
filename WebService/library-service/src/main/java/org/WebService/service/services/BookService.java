package org.WebService.service.services;

import org.WebService.model.Author;
import org.WebService.model.Book;
import org.WebService.service.AbstractService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "Book")
public class BookService extends AbstractService {

    @WebMethod
    public List<Book> getByName(String name) {
        return getManagerFactory().getBookManager().getBookByName(name);
    }

    @WebMethod
    public Book getById(Integer isbn) {
        return getManagerFactory().getBookManager().getBook(isbn);
    }

    @WebMethod
    public List<Book> getAllBooks() {
        return getManagerFactory().getBookManager().getAllBooks();
    }


    @WebMethod
    public List<Book> getBooksByAuthor(Author author) {
        return getManagerFactory().getBookManager().getBooksByAuthor(author);
    }


}
