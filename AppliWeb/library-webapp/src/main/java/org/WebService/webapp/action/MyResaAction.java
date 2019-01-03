package org.WebService.webapp.action;

import org.WebService.resource.AbstractResource;
import org.apache.struts2.interceptor.SessionAware;
import org.webservice.service.services.Book;
import org.webservice.service.services.Borrow;
import org.webservice.service.services.Reservation;
import org.webservice.service.services.UserAccount;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MyResaAction extends AbstractResource implements SessionAware {

    private List<Reservation> reservationList = new ArrayList<>();
    private Map<String, Object> session;
    private Borrow closestReturn;
    private XMLGregorianCalendar closestDate;

    public XMLGregorianCalendar getClosestDate() {
        return closestDate;
    }

    public void setClosestDate(XMLGregorianCalendar closestDate) {
        this.closestDate = closestDate;
    }

    public Borrow getClosestReturn() {
        return closestReturn;
    }

    public void setClosestReturn(Borrow closestReturn) {
        this.closestReturn = closestReturn;
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

        if (reservationList.isEmpty()){
            addActionMessage("Vous n'avez reservé aucun livre pour le moment.");
        }
        else{
            for (Reservation reservation : reservationList){
                Book book = getManagerFactory().getBookManager().getBook(reservation.getISBN());
                reservation.setBook(book);
                closestReturn = getManagerFactory().getBorrowManager().getClosestBorrow(book.getISBN());
                if(closestReturn!= null){
                    closestDate = closestReturn.getEndDate();
                    reservation.setClosest(closestDate);
                }
            }
        }


        return "success";
    }
}
