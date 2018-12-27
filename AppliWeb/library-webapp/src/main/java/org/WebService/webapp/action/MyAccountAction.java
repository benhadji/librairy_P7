package org.WebService.webapp.action;

import org.WebService.resource.AbstractResource;
import org.apache.struts2.interceptor.SessionAware;
import org.webservice.service.services.Book;
import org.webservice.service.services.Borrow;
import org.webservice.service.services.UserAccount;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MyAccountAction extends AbstractResource implements SessionAware{

    private List<Borrow> borrows = new ArrayList<>();
    private String email;
    private Map<String, Object> session;
    private Date currentDate = new Date();
    private boolean reminder;

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
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

    public String execute() {

        if(session.containsKey("sessionUserAccount")) {

            UserAccount user = (UserAccount)session.get("sessionUserAccount");
            email = user.getEmail();
            reminder = user.isReminder();

            borrows = getManagerFactory().getBorrowManager().getBorrowByUserEmail(email);

            for (Borrow borrow : borrows){
                Book book = getManagerFactory().getBookManager().getBook(borrow.getISBN());
                borrow.setBook(book);
            }
            if (reminder){
                addActionMessage("Vous avez activé l'option vous envoyant un mail \n " +
                        "5 jours avant la fin de vos prets");
            }
            else
                addActionMessage("Vous avez desactivé l'option vous envoyant un mail. \n " +
                        "Vous ne recevrez plus la notification de rappel, 5 jours avant la fin de vos prets");

            return "success";

        }
        else
            return LOGIN;


    }

    public String doReminder(){

        UserAccount user = (UserAccount)session.get("sessionUserAccount");
        email = user.getEmail();
        borrows = getManagerFactory().getBorrowManager().getBorrowByUserEmail(email);

        for (Borrow borrow : borrows){
            Book book = getManagerFactory().getBookManager().getBook(borrow.getISBN());
            borrow.setBook(book);
        }

        if (reminder){
            user.setReminder(true);
            getManagerFactory().getUserAccountManager().updateUser(user);
            session.remove("sessionUserAccount");
            session.put("sessionUserAccount", user);
            addActionMessage("Vous avez activé l'option vous envoyant un mail \n " +
                    "5 jours avant la fin de vos prets");
        }
        else{
            user.setReminder(false);
            session.remove("sessionUserAccount");
            session.put("sessionUserAccount", user);
            getManagerFactory().getUserAccountManager().updateUser(user);
            addActionMessage("Vous avez desactivé l'option vous envoyant un mail. \n " +
                    "Vous ne recevrez plus la notification de rappel, 5 jours avant la fin de vos prets");
        }

        return SUCCESS;

    }

}
