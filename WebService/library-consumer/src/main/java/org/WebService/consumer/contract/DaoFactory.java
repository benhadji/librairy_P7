package org.WebService.consumer.contract;

import org.WebService.consumer.contract.DAO.*;

public interface DaoFactory {

    AuthorDAO getAuthorDAO();
    void setAuthorDAO(AuthorDAO authorDAO);

    BookDAO getBookDAO();
    void setBookDAO(BookDAO bookDAO);

    BorrowDAO getBorrowDAO();
    void setBorrowDAO(BorrowDAO borrowDAO);

    EditorDAO getEditorDAO();
    void setEditorDAO(EditorDAO editorDAO);

    UserAccountDAO getUserAccountDAO();
    void setUserAccountDAO(UserAccountDAO userAccountDAO);



}
