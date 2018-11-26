package org.WebService.business.contract.manager;

import org.WebService.model.Book;
import org.WebService.model.Reservation;
import org.WebService.model.UserAccount;

import java.util.List;

public interface ReservationManager {

    List<Reservation> listResaByUser(UserAccount user);
    void addReservation(Book book, UserAccount user);
    List<Reservation> listResaByBook(Book book);
    void updateReservation(Reservation reservation);
    void deleteReservation(Reservation reservation);
    Reservation getResaById(Integer id);


}
