package org.WebService.webapp.action;

import org.WebService.resource.AbstractResource;
import org.apache.struts2.interceptor.SessionAware;
import org.webservice.service.services.Book;
import org.webservice.service.services.Reservation;

import java.util.Map;

public class DeleteReservationAction extends AbstractResource implements SessionAware {

    private Map<String, Object> session;
    private Reservation reservation;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


    public String execute() {

        if(session.containsKey("sessionUserAccount")){

            reservation = getManagerFactory().getReservationManager().getById(Integer.parseInt(id));
            getManagerFactory().getReservationManager().deleteReservation(reservation);

            Book book = getManagerFactory().getBookManager().getBook(reservation.getISBN());

            addActionMessage("La reservation pour le livre : " + book.getTitle() + " a bien annulé !!");
        }
        else
            return "login";




        return "success";
    }


}
