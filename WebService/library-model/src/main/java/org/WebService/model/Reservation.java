package org.WebService.model;

import java.util.Date;

public class Reservation {

    private Integer id;
    private String email;
    private Integer ISBN;
    private Integer position;
    private Date reservationDate;
    private Date sendMailDate;
    private UserAccount user;
    private Book book;

    public Date getSendMailDate() {
        return sendMailDate;
    }

    public void setSendMailDate(Date sendMailDate) {
        this.sendMailDate = sendMailDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
}
