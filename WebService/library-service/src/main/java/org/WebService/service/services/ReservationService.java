package org.WebService.service.services;

import org.WebService.model.Book;
import org.WebService.model.Reservation;
import org.WebService.model.UserAccount;
import org.WebService.service.AbstractService;


import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "Reservation")
public class ReservationService extends AbstractService {

    @WebMethod
    public void addReservation(Book book, UserAccount user){
        getManagerFactory().getReservationManager().addReservation(book, user);
    }

    @WebMethod
    public void updateReservation(Reservation reservation){
        getManagerFactory().getReservationManager().updateReservation(reservation);
    }

    @WebMethod
    public void deleteReservation(Reservation reservation){
        getManagerFactory().getReservationManager().deleteReservation(reservation);
    }

    @WebMethod
    public List<Reservation> listResaByUser(UserAccount user){
        return getManagerFactory().getReservationManager().listResaByUser(user);
    }

    @WebMethod
    public List<Reservation> listResaByBook(Book book){
        return getManagerFactory().getReservationManager().listResaByBook(book);
    }

    @WebMethod
    public Reservation getResaById(Integer id){
        return getManagerFactory().getReservationManager().getResaById(id);
    }

    @WebMethod
    public List<Reservation> getAllReservations(){
        return getManagerFactory().getReservationManager().getAllReservation();
    }

    @WebMethod
    public List<Reservation> getResaJobTicket1(){
        return getManagerFactory().getReservationManager().getResaJobTicket1();
    }

}
