package org.WebService.webapp.action;

import org.WebService.resource.AbstractResource;
import org.apache.struts2.interceptor.SessionAware;
import org.webservice.service.services.Book;
import org.webservice.service.services.Reservation;
import org.webservice.service.services.UserAccount;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyResaAction extends AbstractResource implements SessionAware {

    private List<Reservation> reservationList = new ArrayList<>();
    private Map<String, Object> session;
    private List<Reservation> resaByBook;
    private Integer positionInList;

    public Integer getPositionInList() {
        return positionInList;
    }

    public void setPositionInList(Integer positionInList) {
        this.positionInList = positionInList;
    }

    public List<Reservation> getResaByBook() {
        return resaByBook;
    }

    public void setResaByBook(List<Reservation> resaByBook) {
        this.resaByBook = resaByBook;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }


    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }



    public String execute() throws Exception {

        UserAccount user = (UserAccount)session.get("sessionUserAccount");
        reservationList = getManagerFactory().getReservationManager().listResaByUser(user);

        for (Reservation reservation : reservationList){
            Book book = getManagerFactory().getBookManager().getBook(reservation.getISBN());
            reservation.setBook(book);

            resaByBook = getManagerFactory().getReservationManager().listResaByBook(book);
            positionInList = resaByBook.size();
        }

        return "success";
    }
}
