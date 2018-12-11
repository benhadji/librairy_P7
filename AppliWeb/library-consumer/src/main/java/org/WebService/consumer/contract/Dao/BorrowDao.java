package org.WebService.consumer.contract.Dao;



import org.webservice.service.services.Borrow;

import java.util.List;

public interface BorrowDao {

    void updateBorrow(Borrow borrow);
    void deleteBorrow(Borrow borrow);
    Borrow getBorrow(Borrow borrow);
    List<Borrow> listBorrow(Borrow borrow);
    List<Borrow> getListBorrowByTimeExceeded();
    List<Borrow> getBorrowByEmail(String email);
    void markAsExtended(Borrow borrow);
    List<Borrow> getBorrowByBook(String title);
    Borrow getByID(int parseInt);
    Borrow getClosestBorrow(Integer isbn);

    List<Borrow> sendMailReminder();
}
