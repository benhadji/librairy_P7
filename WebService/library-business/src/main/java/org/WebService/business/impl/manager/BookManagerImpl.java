package org.WebService.business.impl.manager;

import org.WebService.business.contract.manager.BookManager;
import org.WebService.model.Author;
import org.WebService.model.Book;

import java.util.List;

public class BookManagerImpl extends AbstractManagerImpl implements BookManager {

    @Override
    public Book getBook(Integer id) {

        return getDaoFactory().getBookDAO().getById(id);

    }

    @Override
    public void createBook(Book book) {

        getDaoFactory().getBookDAO().create(book);

    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        return getDaoFactory().getBookDAO().getBooksByAuthor(author);
    }

    @Override
    public List<Book> getAllBooks() {

        return getDaoFactory().getBookDAO().getAllBooks();
    }

    @Override
    public List<Book> getBookByName(String name) {
        List<Book> vList = getDaoFactory().getBookDAO().getByName(name);

        return vList;
    }
}
