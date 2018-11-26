package org.WebService.consumer.contract.Dao;

import org.webservice.service.services.Book;
import org.webservice.service.services.Reservation;
import org.webservice.service.services.UserAccount;

import java.util.List;

public interface ReservationDao {

    List<Reservation> listResaByUser(UserAccount user);
    void addReservation(Book book, UserAccount userAccount);
    List<Reservation> listResaByBook(Book book);
    void updateReservation(Reservation reservation);
    void deleteReservation(Reservation reservation);
    Reservation getById(int id);
}
