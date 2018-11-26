package org.WebService.consumer.impl.Dao;

import org.WebService.consumer.contract.Dao.ReservationDao;
import org.webservice.service.services.*;

import java.util.List;

public class ReservationDaoImpl implements ReservationDao {


    private Reservation_Service reservationService = new Reservation_Service();
    private ReservationService resaSrv = reservationService.getReservationServicePort();



    public Reservation_Service getReservationService() {
        return reservationService;
    }

    public void setReservationService(Reservation_Service reservationService) {
        this.reservationService = reservationService;
    }

    public ReservationService getResaSrv() {
        return resaSrv;
    }

    public void setResaSrv(ReservationService resaSrv) {
        this.resaSrv = resaSrv;
    }



    @Override
    public List<Reservation> listResaByUser(UserAccount user) {
        return resaSrv.listResaByUser(user);
    }

    @Override
    public void addReservation(Book book, UserAccount user) {
        resaSrv.addReservation(book, user);
    }

    @Override
    public List<Reservation> listResaByBook(Book book) {
        return resaSrv.listResaByBook(book);
    }

    @Override
    public void updateReservation(Reservation reservation) {
        resaSrv.updateReservation(reservation);
    }

    @Override
    public void deleteReservation(Reservation reservation) {
        resaSrv.deleteReservation(reservation);
    }

    @Override
    public Reservation getById(int id) {
        return resaSrv.getResaById(id);
    }
}
