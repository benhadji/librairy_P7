package org.WebService.consumer.impl;

import org.WebService.consumer.contract.Dao.*;
import org.WebService.consumer.contract.DaoFactory;

public class DaoFactoryImpl implements DaoFactory{

    private AuthorDao authorDao;
    private BookDao bookDao;
    private BorrowDao borrowDao;
    private EditorDao editorDao;
    private UserDao userDao;


    @Override
    public AuthorDao getAuthorDAO() {
        return authorDao;
    }

    @Override
    public void setAuthorDAO(AuthorDao authorDAO) {
        authorDao = authorDAO;
    }

    @Override
    public BookDao getBookDAO() {
        return bookDao;
    }

    @Override
    public void setBookDAO(BookDao bookDAO) {
        bookDao = bookDAO;
    }

    @Override
    public BorrowDao getBorrowDAO() {
        return borrowDao;
    }

    @Override
    public void setBorrowDAO(BorrowDao borrowDAO) {
        borrowDao = borrowDAO;
    }

    @Override
    public EditorDao getEditorDAO() {
        return editorDao;
    }

    @Override
    public void setEditorDAO(EditorDao editorDAO) {
        editorDao = editorDAO;
    }

    @Override
    public UserDao getUserDAO() {
        return userDao;
    }

    @Override
    public void setUserDAO(UserDao userDAO) {
        userDao = userDAO;
    }


}
