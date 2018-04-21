package org.WebService.webapp.action;

import org.WebService.resource.AbstractResource;
import org.apache.struts2.interceptor.SessionAware;
import org.webservice.service.services.Book;
import org.webservice.service.services.Borrow;


import java.util.Map;

public class ExtendBorrowAction extends AbstractResource implements SessionAware{


    private String id;
    private Map<String, Object> session;
    private Borrow borrow;

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }



    public String execute(){

        if(session.containsKey("sessionUserAccount")) {

            borrow = getManagerFactory().getBorrowManager().getById(Integer.parseInt(id));

            if(borrow != null){

                getManagerFactory().getBorrowManager().markAsExtended(borrow);
                Book book = getManagerFactory().getBookManager().getBook(borrow.getISBN());

                addActionMessage("Le livre " + book.getTitle() + " a bien prolongé !!");
                return "success";
            }
            else
                return "home";

        }
        else{
            return "login";
        }


    }



}
