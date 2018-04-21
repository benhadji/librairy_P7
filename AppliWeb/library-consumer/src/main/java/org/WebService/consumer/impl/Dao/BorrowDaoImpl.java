package org.WebService.consumer.impl.Dao;

import org.WebService.consumer.contract.Dao.BorrowDao;
import org.webservice.service.services.Borrow;
import org.webservice.service.services.BorrowService;
import org.webservice.service.services.Borrow_Service;


import java.util.List;

public class BorrowDaoImpl implements BorrowDao {


    private Borrow_Service borrowService = new Borrow_Service();
    private BorrowService borrowSrv = borrowService.getBorrowServicePort();

    public Borrow_Service getBorrowService() {
        return borrowService;
    }

    public void setBorrowService(Borrow_Service borrowService) {
        this.borrowService = borrowService;
    }

    public BorrowService getBorrowSrv() {
        return borrowSrv;
    }

    public void setBorrowSrv(BorrowService borrowSrv) {
        this.borrowSrv = borrowSrv;
    }



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
        return borrowSrv.getBorrowByBook(ISBN);
    }

    @Override
    public List<Borrow> listBorrow(Borrow borrow) {
        return null;
    }

    @Override
    public List<Borrow> getListBorrowByTimeExceeded() {
        return borrowSrv.getLateBorrows();
    }

    @Override
    public List<Borrow> getBorrowByEmail(String email) {
        return borrowSrv.getBorrowByUserEmail(email);
    }

    @Override
    public void markAsExtended(Borrow borrow) {
        borrowSrv.markBorrowAsExtended(borrow);
    }

    @Override
    public Borrow getById(Integer id) {
        return borrowSrv.getBorrowById(id);
    }
}
