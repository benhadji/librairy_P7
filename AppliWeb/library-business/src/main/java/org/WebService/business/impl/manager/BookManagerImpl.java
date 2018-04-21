package org.WebService.business.impl.manager;

import org.WebService.business.AbstractManager;
import org.WebService.business.contract.manager.BookManager;
import org.webservice.service.services.Author;
import org.webservice.service.services.Book;
import org.webservice.service.services.Editor;


import java.util.Iterator;
import java.util.List;

public class BookManagerImpl extends AbstractManager implements BookManager {


    @Override
    public Book getBook(long id) {
        return getDaoFactory().getBookDAO().getBook(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return getDaoFactory().getBookDAO().getAllBooks();
    }

    @Override
    public List<Book> getBookByName(String name) {
        return getDaoFactory().getBookDAO().getBookByName(name);
    }

}
