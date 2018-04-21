package org.WebService.business.contract.manager;



import org.webservice.service.services.Book;

import java.util.List;

public interface BookManager {

    Book getBook(long id);
    List<Book> getAllBooks();
    List<Book> getBookByName(String name);



}
