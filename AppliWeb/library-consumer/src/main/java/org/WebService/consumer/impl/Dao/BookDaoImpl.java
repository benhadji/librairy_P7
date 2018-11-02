package org.WebService.consumer.impl.Dao;

import org.WebService.consumer.contract.Dao.BookDao;
import org.webservice.service.services.Author;
import org.webservice.service.services.Book;
import org.webservice.service.services.BookService;
import org.webservice.service.services.Book_Service;


import java.util.List;

public class BookDaoImpl implements BookDao {

    private Book_Service bookService = new Book_Service();
    private BookService bookSrv = bookService.getBookServicePort();

    public Book_Service getBookService() {
        return bookService;
    }

    public void setBookService(Book_Service bookService) {
        this.bookService = bookService;
    }

    public BookService getBookSrv() {
        return bookSrv;
    }

    public void setBookSrv(BookService bookSrv) {
        this.bookSrv = bookSrv;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookSrv.getAllBooks();
    }

    @Override
    public List<Book> getBookByName(String name) {
        return bookSrv.getByName(name);
    }

    @Override
    public List<Book> getBookByAuthor(Author author) {
        return bookSrv.getBooksByAuthor(author);
    }

    @Override
    public Book getBook(Integer id) {
        return bookSrv.getById(id);
    }
}
