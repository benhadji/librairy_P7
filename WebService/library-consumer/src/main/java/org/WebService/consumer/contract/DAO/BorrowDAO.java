package org.WebService.consumer.contract.DAO;

import org.WebService.model.Borrow;

import java.util.List;

public interface BorrowDAO{

    void create(Borrow borrow);
    void update(Borrow borrow);
    void markAsExtended(Borrow borrow);
    List<Borrow> getLateReturns();
    List<Borrow> getByUserEmail(String email);
    List<Borrow> getListBorrows();
    List<Borrow> getBorrowByBook(String title);
    Borrow getBorrowById(int id);
}
