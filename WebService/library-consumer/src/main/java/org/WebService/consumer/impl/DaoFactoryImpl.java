package org.WebService.consumer.impl;

import org.WebService.consumer.contract.DAO.*;
import org.WebService.consumer.contract.DaoFactory;

public class DaoFactoryImpl implements DaoFactory{

    private AuthorDAO authorDAO;
    private BookDAO bookDAO;
    private BorrowDAO borrowDAO;
    private EditorDAO editorDAO;
    private UserAccountDAO userAccountDAO;
    private ReservationDAO reservationDAO;




    @Override
    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    @Override
    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public BookDAO getBookDAO() {
        return bookDAO;
    }

    @Override
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public BorrowDAO getBorrowDAO() {
        return borrowDAO;
    }

    @Override
    public void setBorrowDAO(BorrowDAO borrowDAO) {
        this.borrowDAO = borrowDAO;
    }

    @Override
    public EditorDAO getEditorDAO() {
        return editorDAO;
    }

    @Override
    public void setEditorDAO(EditorDAO editorDAO) {
        this.editorDAO = editorDAO;
    }

    @Override
    public UserAccountDAO getUserAccountDAO() {
        return userAccountDAO;
    }

    @Override
    public void setUserAccountDAO(UserAccountDAO userAccountDAO) {
        this.userAccountDAO = userAccountDAO;
    }

    @Override
    public ReservationDAO getReservationDAO() {
        return reservationDAO;
    }

    @Override
    public void setReservationDAO(ReservationDAO reservationDAO) {
        this.reservationDAO = reservationDAO;
    }
}
