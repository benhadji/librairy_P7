package org.WebService.business.impl.manager;

import org.WebService.business.AbstractManager;
import org.WebService.business.contract.manager.ReservationManager;
import org.webservice.service.services.Book;
import org.webservice.service.services.Reservation;
import org.webservice.service.services.UserAccount;

import java.util.List;

public class ReservationManagerImpl extends AbstractManager implements ReservationManager {
    @Override
    public List<Reservation> listResaByUser(UserAccount user) {
        return getDaoFactory().getReservationDAO().listResaByUser(user);
    }

    @Override
    public void addReservation(Book book, UserAccount userAccount) {
        getDaoFactory().getReservationDAO().addReservation(book, userAccount);
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
    public Reservation getById(int id) {
        return getDaoFactory().getReservationDAO().getById(id);
    }

    @Override
    public List<Reservation> getAllReservatons() {
        return getDaoFactory().getReservationDAO().getAllReservations();
    }

    @Override
    public List<Reservation> getResaJobTicket1() {
        return getDaoFactory().getReservationDAO().getResaJobTicket1();
    }
}
