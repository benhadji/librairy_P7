package org.WebService.consumer.contract.Dao;



import org.webservice.service.services.Borrow;

import java.util.List;

public interface BorrowDao {

    void updateBorrow(Borrow borrow);
    void deleteBorrow(Borrow borrow);
    Borrow getBorrow(Borrow borrow);
    List<Borrow> getBorrowByISBN(Integer ISBN);
    List<Borrow> listBorrow(Borrow borrow);
    List<Borrow> getListBorrowByTimeExceeded();


    List<Borrow> getBorrowByEmail(String email);

    void markAsExtended(Borrow borrow);

    Borrow getById(Integer id);
}
