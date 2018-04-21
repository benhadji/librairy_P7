package org.WebService.business.impl.manager;

import org.WebService.business.AbstractManager;
import org.WebService.business.contract.manager.BorrowManager;
import org.webservice.service.services.Borrow;
import java.util.List;

public class BorrowManagerImpl extends AbstractManager implements BorrowManager {


    @Override
    public void updateBorrow(Borrow borrow) {

    }

    @Override
    public void deleteBorrow(Borrow borrow) {

    }

    @Override
    public Borrow getBorrow(Borrow borrow) {
        return null;
    }

    @Override
    public List<Borrow> getBorrowByISBN(Integer ISBN) {
        return getDaoFactory().getBorrowDAO().getBorrowByISBN(ISBN);
    }

    @Override
    public List<Borrow> listBorrow(Borrow borrow) {
        return null;
    }

    @Override
    public List<Borrow> getListBorrowByTimeExceeded() {
        return getDaoFactory().getBorrowDAO().getListBorrowByTimeExceeded();
    }

    @Override
    public List<Borrow> getBorrowByUserEmail(String email) {

        return getDaoFactory().getBorrowDAO().getBorrowByEmail(email);
    }

    @Override
    public void markAsExtended(Borrow borrow) {
        getDaoFactory().getBorrowDAO().markAsExtended(borrow);
    }

    @Override
    public Borrow getById(Integer id) {
        return getDaoFactory().getBorrowDAO().getById(id);
    }
}
