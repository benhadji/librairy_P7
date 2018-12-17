package org.WebService.business.impl.manager;

import org.WebService.business.contract.manager.*;

public class ManagerFactoryImpl implements ManagerFactory{

    private AuthorManager authorManager;
    private BookManager bookManager;
    private BorrowManager borrowManager;
    private EditorManager editorManager;
    private UserManager userManager;
    private ReservationManager reservationManager;




    @Override
    public AuthorManager getAuthorManager() {
        return authorManager;
    }

    @Override
    public void setAuthorManager(AuthorManager authorManager) {
        this.authorManager = authorManager;
    }

    @Override
    public BookManager getBookManager() {
        return bookManager;
    }

    @Override
    public void setBookManager(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @Override
    public BorrowManager getBorrowManager() {
        return borrowManager;
    }

    @Override
    public void setBorrowManager(BorrowManager borrowManager) {
        this.borrowManager = borrowManager;
    }

    @Override
    public EditorManager getEditorManager() {
        return editorManager;
    }

    @Override
    public void setEditorManager(EditorManager editorManager) {
        this.editorManager = editorManager;
    }

    @Override
    public UserManager getUserAccountManager() {
        return userManager;
    }

    @Override
    public void setUserAccountManager(UserManager userAccountManager) {
        userManager = userAccountManager;
    }

    @Override
    public ReservationManager getReservationManager() {
        return reservationManager;
    }

    @Override
    public void setReservationManager(ReservationManager reservationManager) {
        this.reservationManager = reservationManager;
    }
}
