package org.WebService.webapp.action;

import org.WebService.resource.AbstractResource;
import org.webservice.service.services.Author;
import org.webservice.service.services.Book;
import org.webservice.service.services.Editor;


import java.util.List;

public class SearchAction extends AbstractResource {

    private List<Book> bookName;
    private List<Author> authorName;
    private String jspName;
    private Author author;
    private Editor editor;
    private Integer NbOfBooks;
    private Book book;
    private String ISBN;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Integer getNbOfBooks() {
        return NbOfBooks;
    }

    public void setNbOfBooks(Integer nbOfBooks) {
        NbOfBooks = nbOfBooks;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

            for (Book book : bookName){
                author = getManagerFactory().getAuthorManager().getAuthorByBookTitle(book.getTitle());
                editor = getManagerFactory().getEditorManager().getByBookTitle(book.getTitle());
                book.setAuthor(author);
                book.setEditor(editor);
            }



        } else if (getManagerFactory().getAuthorManager().getAuthorByName(jspName).size() > 0) {
            authorName = getManagerFactory().getAuthorManager().getAuthorByName(jspName);

            for (Author author : authorName){
                bookName = getManagerFactory().getBookManager().getBooksByAuthor(author);
                NbOfBooks = bookName.size();
            }

        }

        return SUCCESS;


    }

}
