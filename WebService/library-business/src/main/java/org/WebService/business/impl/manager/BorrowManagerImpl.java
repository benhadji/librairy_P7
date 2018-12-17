package org.WebService.business.impl.manager;

import org.WebService.business.contract.manager.BorrowManager;
import org.WebService.model.Book;
import org.WebService.model.Borrow;

import java.util.Iterator;
import java.util.List;

public class BorrowManagerImpl extends AbstractManagerImpl implements BorrowManager {


    @Override
    public List<Borrow> getBorrowByUserEmail(String email) {

        return getDaoFactory().getBorrowDAO().getByUserEmail(email);

    }

    @Override
    public List<Borrow> getAllBorrows() {
        return getDaoFactory().getBorrowDAO().getListBorrows();
    }

    @Override
    public void newBorrow(Borrow borrow) {
        getDaoFactory().getBorrowDAO().create(borrow);

    }

    @Override
    public void updateBorrow(Borrow borrow) {
        getDaoFactory().getBorrowDAO().update(borrow);
    }


    @Override
    public void markAsExtended(Borrow borrow) {
        getDaoFactory().getBorrowDAO().markAsExtended(borrow);
    }

    @Override
    public List<Borrow> getLateBorrows() {
        return getDaoFactory().getBorrowDAO().getLateReturns();
    }

    @Override
    public List<Borrow> getBorrowByBook(String title) {
        return getDaoFactory().getBorrowDAO().getBorrowByBook(title);
    }

    @Override
    public Borrow getByID(int id) {
        return getDaoFactory().getBorrowDAO().getBorrowById(id);
    }

    @Override
    public Borrow getClosestBorrow(Integer isbn) {
        return getDaoFactory().getBorrowDAO().getClosestBorrow(isbn);
    }

    @Override
    public List<Borrow> sendMailReminder() {
        return getDaoFactory().getBorrowDAO().sendMailReminder();
    }


}
