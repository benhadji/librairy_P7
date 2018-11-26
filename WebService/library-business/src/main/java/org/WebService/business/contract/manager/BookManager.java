package org.WebService.business.contract.manager;

import org.WebService.model.Author;
import org.WebService.model.Book;
import org.WebService.model.UserAccount;

import java.util.List;

public interface BookManager {

    Book getBook(Integer id);
    List<Book> getAllBooks();
    List<Book> getBookByName(String name);
    void createBook(Book book);
    List<Book> getBooksByAuthor(Author author);
}
