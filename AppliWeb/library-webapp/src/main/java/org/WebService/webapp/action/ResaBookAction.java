package org.WebService.webapp.action;

import com.opensymphony.xwork2.ActionContext;
import org.WebService.resource.AbstractResource;
import org.apache.struts2.interceptor.SessionAware;
import org.webservice.service.services.Book;
import org.webservice.service.services.Reservation;
import org.webservice.service.services.UserAccount;
import java.util.*;


public class ResaBookAction extends AbstractResource implements SessionAware {


    private Map<String, Object> session;
    private Book book;
    private UserAccount user;
    private List<Reservation> reservationListByUser = new ArrayList<>();
    private List<Reservation> reservationListByBook = new ArrayList<>();
    private String ISBN;



    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }



    public List<Reservation> getReservationListByUser() {
        return reservationListByUser;
    }

    public void setReservationListByUser(List<Reservation> reservationListByUser) {
        this.reservationListByUser = reservationListByUser;
    }

    public List<Reservation> getReservationListByBook() {
        return reservationListByBook;
    }

    public void setReservationListByBook(List<Reservation> reservationListByBook) {
        this.reservationListByBook = reservationListByBook;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }




    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


    public String execute() throws Exception {

        if(session.containsKey("sessionUserAccount")) {

            user = (UserAccount) ActionContext.getContext().getSession().get("sessionUserAccount");
            book = getManagerFactory().getBookManager().getBook(Integer.parseInt(ISBN));

            reservationListByUser = getManagerFactory().getReservationManager().listResaByUser(user);

            if (reservationListByUser.size() == 0){
                getManagerFactory().getReservationManager().addReservation(book, user);
                reservationListByBook = getManagerFactory().getReservationManager().listResaByBook(book);

                if(reservationListByBook.size() == 1){
                    addActionMessage("La reservation a bien ete pris en compte.\n " +
                            "Vous est le premier sur la liste d'attente pour le pret du livre.");
                }
                else if (reservationListByBook.size() > 1){
                    addActionMessage("La reservation a bien ete pris en compte.\n " +
                            "Vous est en "+ reservationListByBook.size() + " position dans la liste d'attente pour le pret du livre.");
                }
            }
            else{
                for (Reservation reservation : reservationListByUser){
                    if (reservation.getISBN().equals(book.getISBN())){
                        addActionMessage("Vous avez deja reservé ce livre !");
                    }
                }
            }
            return "success";
        }
        else{
            return "login";
        }

    }

}
