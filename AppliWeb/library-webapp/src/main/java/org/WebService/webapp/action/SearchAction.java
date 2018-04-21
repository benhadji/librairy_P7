package org.WebService.webapp.action;

import org.WebService.resource.AbstractResource;
import org.webservice.service.services.Author;
import org.webservice.service.services.Book;


import java.util.List;

public class SearchAction extends AbstractResource {

    private List<Book> bookName;
    private List<Author> authorName;
    private String jspName;
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookName() {
        return bookName;
    }

    public void setBookName(List<Book> bookName) {
        this.bookName = bookName;
    }

    public List<Author> getAuthorName() {
        return authorName;
    }

    public void setAuthorName(List<Author> authorName) {
        this.authorName = authorName;
    }

    public String getJspName() {
        return jspName;
    }

    public void setJspName(String jspName) {
        this.jspName = jspName;
    }

    public String execute() throws Exception {

        if (getManagerFactory().getBookManager().getBookByName(jspName).size() > 0) {
            bookName = getManagerFactory().getBookManager().getBookByName(jspName);

        } else if (getManagerFactory().getAuthorManager().getAuthorByName(jspName).size() > 0) {
            authorName = getManagerFactory().getAuthorManager().getAuthorByName(jspName);

        }

        return SUCCESS;


    }

}
