package org.WebService.business.contract.manager;

import org.WebService.model.Borrow;

import java.util.List;

public interface BorrowManager {


    List<Borrow> getBorrowByUserEmail(String email);
    List<Borrow> getAllBorrows();
    void newBorrow(Borrow borrow);
    void updateBorrow(Borrow borrow);
    void markAsExtended(Borrow borrow);
    List<Borrow> getLateBorrows();
    List<Borrow> getBorrowByBook(String title);
    Borrow getByID(int id);
}
