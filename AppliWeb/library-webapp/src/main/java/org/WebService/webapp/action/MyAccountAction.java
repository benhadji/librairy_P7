package org.WebService.webapp.action;

import org.WebService.resource.AbstractResource;
import org.apache.struts2.interceptor.SessionAware;
import org.webservice.service.services.Book;
import org.webservice.service.services.Borrow;
import org.webservice.service.services.UserAccount;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyAccountAction extends AbstractResource implements SessionAware{

    private List<Borrow> borrows = new ArrayList<>();
    private String email;
    private Map<String, Object> session;
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String execute() throws Exception {

        UserAccount user = (UserAccount)session.get("sessionUserAccount");
        email = user.getEmail();

        borrows = getManagerFactory().getBorrowManager().getBorrowByUserEmail(email);

        return "success";
    }


}
