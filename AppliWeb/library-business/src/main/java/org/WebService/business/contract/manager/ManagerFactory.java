package org.WebService.business.contract.manager;

public interface ManagerFactory {

    AuthorManager getAuthorManager();
    void setAuthorManager(AuthorManager authorManager);

    BookManager getBookManager();
    void setBookManager(BookManager bookManager);

    BorrowManager getBorrowManager();
    void setBorrowManager(BorrowManager borrowManager);

    EditorManager getEditorManager();
    void setEditorManager(EditorManager editorManager);

    UserManager getUserAccountManager();
    void setUserAccountManager(UserManager userAccountManager);

    ReservationManager getReservationManager();
    void setReservationManager(ReservationManager reservationManager);



}
