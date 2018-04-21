package org.WebService.consumer.contract.DAO;


import org.WebService.model.Author;
import org.WebService.model.Book;

import java.util.List;

public interface BookDAO {

    void create(Book book);
    Book getById(long id);
    List<Book> getAllBooks();
    List<Book> getByName(String name);
    List<Book> getByAuthor(Author author);

}
