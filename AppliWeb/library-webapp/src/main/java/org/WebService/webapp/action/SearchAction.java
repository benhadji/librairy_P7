package org.WebService.webapp.action;

import org.WebService.resource.AbstractResource;
import org.apache.struts2.interceptor.SessionAware;
import org.webservice.service.services.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SearchAction extends AbstractResource implements SessionAware {

    private List<Book> bookName;
    private List<Author> authorName;
    private List<Borrow> borrowList;
    private String jspName;
    private Author author;
    private Editor editor;
    private Integer NbOfBooks;
    private Book book;
    private String ISBN;
    private List<Reservation> reservationListByBook = new ArrayList<>();
    private Integer resaLimits;
    private Borrow closestReturn;
    private Date closestEndDate;
    private Map<String, Object> session;
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<Borrow> getBorrowList() {
        return borrowList;
    }

    public void setBorrowList(List<Borrow> borrowList) {
        this.borrowList = borrowList;
    }

    public Date getClosestEndDate() {
        return closestEndDate;
    }

    public void setClosestEndDate(Date closestEndDate) {
        this.closestEndDate = closestEndDate;
    }

    public Borrow getClosestReturn() {
        return closestReturn;
    }

    public void setClosestReturn(Borrow closestReturn) {
        this.closestReturn = closestReturn;
    }

    public Integer getResaLimits() {
        return resaLimits;
    }

    public void setResaLimits(Integer resaLimits) {
        this.resaLimits = resaLimits;
    }

    public List<Reservation> getReservationListByBook() {
        return reservationListByBook;
    }

    public void setReservationListByBook(List<Reservation> reservationListByBook) {
        this.reservationListByBook = reservationListByBook;
    }

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

        if(session.containsKey("sessionUserAccount")) {

            if (getManagerFactory().getBookManager().getBookByName(jspName).size() > 0) {

                bookName = getManagerFactory().getBookManager().getBookByName(jspName);
                UserAccount user = (UserAccount)session.get("sessionUserAccount");
                borrowList = getManagerFactory().getBorrowManager().getBorrowByUserEmail(user.getEmail());


                for (Book book : bookName){

                        author = getManagerFactory().getAuthorManager().getAuthorByBookTitle(book.getTitle());
                        editor = getManagerFactory().getEditorManager().getByBookTitle(book.getTitle());
                        reservationListByBook = getManagerFactory().getReservationManager().listResaByBook(book);
                        closestReturn = getManagerFactory().getBorrowManager().getClosestBorrow(book.getISBN());
                        book.setAuthor(author);
                        book.setEditor(editor);

                        resaLimits = book.getNbOfCopy()*2;
                        closestReturn = getManagerFactory().getBorrowManager().getClosestBorrow(book.getISBN());
                        closestEndDate = closestReturn.getEndDate().toGregorianCalendar().getTime();

                        for (Borrow borrow : borrowList){  // Pour vois si le user a emprunter le livre qu'il veut reserver
                            System.out.println("L'ID du livre est : "+ borrow.getISBN());
                            flag = false;
                            if (book.getISBN().equals(borrow.getISBN())){
                                flag = true;
                                System.out.println("Flag is true !!");
                            }
                        }

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
        else
            return LOGIN;





    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
