package org.WebService.consumer.contract.Dao;


import org.webservice.service.services.Author;
import org.webservice.service.services.Book;

import java.util.List;

public interface BookDao {

    Book getBook(Integer id);
    List<Book> getAllBooks();
    List<Book> getBookByName(String name);

    List<Book> getBookByAuthor(Author author);
}
