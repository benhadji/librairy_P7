package org.WebService.business.impl.manager;

import org.WebService.business.contract.manager.*;

public class ManagerFactoryImpl implements ManagerFactory {


    private AuthorManager authorManager;
    private BookManager bookManager;
    private BorrowManager borrowManager;
    private EditorManager editorManager;
    private UserAccountManager userAccountManager;


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
    public UserAccountManager getUserAccountManager() {
        return userAccountManager;
    }

    @Override
    public void setUserAccountManager(UserAccountManager userAccountManager) {
        this.userAccountManager = userAccountManager;
    }
}
