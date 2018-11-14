package org.WebService.consumer.contract.DAO;

import org.WebService.model.Book;
import org.WebService.model.Reservation;
import org.WebService.model.UserAccount;

import java.util.List;

public interface ReservationDAO {

    List<Reservation> listResaByUser(UserAccount user);
    void addReservation(Reservation reservation);
    List<Reservation> listResaByBook(Book book);
    void updateReservation(Reservation reservation);
    void deleteReservation(Reservation reservation);

}
