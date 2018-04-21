package org.WebService.consumer.contract;

import org.WebService.consumer.contract.Dao.*;

public interface DaoFactory {

    AuthorDao getAuthorDAO();
    void setAuthorDAO(AuthorDao authorDAO);

    BookDao getBookDAO();
    void setBookDAO(BookDao bookDAO);

    BorrowDao getBorrowDAO();
    void setBorrowDAO(BorrowDao borrowDAO);

    EditorDao getEditorDAO();
    void setEditorDAO(EditorDao editorDAO);

    UserDao getUserDAO();
    void setUserDAO(UserDao userDAO);




}
