package org.WebService.service.services;

import org.WebService.model.Borrow;
import org.WebService.service.AbstractService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "Borrow")
public class BorrowService extends AbstractService {

    @WebMethod
    public List<Borrow> getAllBorrows(){
        return getManagerFactory().getBorrowManager().getAllBorrows();
    }

    @WebMethod
    public void markBorrowAsExtended(Borrow borrow) {
        getManagerFactory().getBorrowManager().markAsExtended(borrow);
    }

    @WebMethod
    public void saveNewBorrow(Borrow borrow)
    {
        getManagerFactory().getBorrowManager().newBorrow(borrow);
    }

    @WebMethod
    public void updateBorrow(Borrow borrow)
    {
        getManagerFactory().getBorrowManager().updateBorrow(borrow);
    }

    @WebMethod
    public List<Borrow> getLateBorrows()
    {
        return getManagerFactory().getBorrowManager().getLateBorrows();
    }

    @WebMethod
    public List<Borrow> getBorrowByUserEmail(String email){
        return getManagerFactory().getBorrowManager().getBorrowByUserEmail(email);
    }

    @WebMethod
    public List<Borrow> getLateReturns(){
        return getManagerFactory().getBorrowManager().getLateBorrows();
    }

    @WebMethod
    public List<Borrow> getBorrowByBook(String title){
        return getManagerFactory().getBorrowManager().getBorrowByBook(title);
    }

    @WebMethod
    public Borrow getBorrowById(Integer id){
        return getManagerFactory().getBorrowManager().getByID(id);
    }



}
