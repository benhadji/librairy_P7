package org.WebService.business.contract.manager;



import org.webservice.service.services.Borrow;

import java.util.Date;
import java.util.List;

public interface BorrowManager {

    void updateBorrow(Borrow borrow);
    void deleteBorrow(Borrow borrow);
    Borrow getBorrow(Borrow borrow);
    List<Borrow> getBorrowByBook(String title);
    List<Borrow> listBorrow(Borrow borrow);
    List<Borrow> getListBorrowByTimeExceeded();
    List<Borrow> getBorrowByUserEmail(String email);
    void markAsExtended(Borrow borrow);
    Borrow getById(int parseInt);
    Borrow getClosestBorrow(Integer isbn);

    List<Borrow> sendMailReminder();
}
