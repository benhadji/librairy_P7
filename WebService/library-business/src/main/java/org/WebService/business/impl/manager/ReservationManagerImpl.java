package org.WebService.business.impl.manager;

import org.WebService.business.contract.manager.ReservationManager;
import org.WebService.model.Book;
import org.WebService.model.Reservation;
import org.WebService.model.UserAccount;
import org.springframework.security.core.userdetails.User;

import java.util.Date;
import java.util.List;

public class ReservationManagerImpl extends AbstractManagerImpl implements ReservationManager {

    @Override
    public List<Reservation> listResaByUser(UserAccount user) {

        return getDaoFactory().getReservationDAO().listResaByUser(user);
    }

    @Override
    public void addReservation(Book book, UserAccount user) {

        int position;
        boolean nbOfBorrowerReached = false;
        List<Reservation> reservationListByBook = this.listResaByBook(book);

        Reservation reservation = new Reservation();
        reservation.setISBN(book.getISBN());
        reservation.setEmail(user.getEmail());
        reservation.setReservationDate(new Date());


        if(reservationListByBook.isEmpty()){
            position = 1;
        }
        else{
            position = reservationListByBook.size() + 1;
        }

        reservation.setPosition(position);

        getDaoFactory().getReservationDAO().addReservation(reservation);
    }

    @Override
    public List<Reservation> listResaByBook(Book book) {

        return getDaoFactory().getReservationDAO().listResaByBook(book);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        getDaoFactory().getReservationDAO().updateReservation(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        getDaoFactory().getReservationDAO().deleteReservation(reservation);
    }

    @Override
    public Reservation getResaById(Integer id) {
        return getDaoFactory().getReservationDAO().getResaById(id);
    }


}
