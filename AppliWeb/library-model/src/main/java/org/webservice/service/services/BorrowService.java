
package org.webservice.service.services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BorrowService", targetNamespace = "http://services.service.WebService.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BorrowService {


    /**
     * 
     * @param arg0
     * @return
     *     returns org.webservice.service.services.Borrow
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBorrowById", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.GetBorrowById")
    @ResponseWrapper(localName = "getBorrowByIdResponse", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.GetBorrowByIdResponse")
    @Action(input = "http://services.service.WebService.org/BorrowService/getBorrowByIdRequest", output = "http://services.service.WebService.org/BorrowService/getBorrowByIdResponse")
    public Borrow getBorrowById(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @return
     *     returns java.util.List<org.webservice.service.services.Borrow>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getLateBorrows", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.GetLateBorrows")
    @ResponseWrapper(localName = "getLateBorrowsResponse", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.GetLateBorrowsResponse")
    @Action(input = "http://services.service.WebService.org/BorrowService/getLateBorrowsRequest", output = "http://services.service.WebService.org/BorrowService/getLateBorrowsResponse")
    public List<Borrow> getLateBorrows();

    /**
     * 
     * @return
     *     returns java.util.List<org.webservice.service.services.Borrow>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getLateReturns", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.GetLateReturns")
    @ResponseWrapper(localName = "getLateReturnsResponse", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.GetLateReturnsResponse")
    @Action(input = "http://services.service.WebService.org/BorrowService/getLateReturnsRequest", output = "http://services.service.WebService.org/BorrowService/getLateReturnsResponse")
    public List<Borrow> getLateReturns();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "updateBorrow", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.UpdateBorrow")
    @ResponseWrapper(localName = "updateBorrowResponse", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.UpdateBorrowResponse")
    @Action(input = "http://services.service.WebService.org/BorrowService/updateBorrowRequest", output = "http://services.service.WebService.org/BorrowService/updateBorrowResponse")
    public void updateBorrow(
        @WebParam(name = "arg0", targetNamespace = "")
        Borrow arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<org.webservice.service.services.Borrow>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBorrowByBook", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.GetBorrowByBook")
    @ResponseWrapper(localName = "getBorrowByBookResponse", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.GetBorrowByBookResponse")
    @Action(input = "http://services.service.WebService.org/BorrowService/getBorrowByBookRequest", output = "http://services.service.WebService.org/BorrowService/getBorrowByBookResponse")
    public List<Borrow> getBorrowByBook(
        @WebParam(name = "arg0", targetNamespace = "")
        Integer arg0);

    /**
     * 
     * @return
     *     returns java.util.List<org.webservice.service.services.Borrow>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllBorrows", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.GetAllBorrows")
    @ResponseWrapper(localName = "getAllBorrowsResponse", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.GetAllBorrowsResponse")
    @Action(input = "http://services.service.WebService.org/BorrowService/getAllBorrowsRequest", output = "http://services.service.WebService.org/BorrowService/getAllBorrowsResponse")
    public List<Borrow> getAllBorrows();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<org.webservice.service.services.Borrow>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBorrowByUserEmail", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.GetBorrowByUserEmail")
    @ResponseWrapper(localName = "getBorrowByUserEmailResponse", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.GetBorrowByUserEmailResponse")
    @Action(input = "http://services.service.WebService.org/BorrowService/getBorrowByUserEmailRequest", output = "http://services.service.WebService.org/BorrowService/getBorrowByUserEmailResponse")
    public List<Borrow> getBorrowByUserEmail(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "markBorrowAsExtended", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.MarkBorrowAsExtended")
    @ResponseWrapper(localName = "markBorrowAsExtendedResponse", targetNamespace = "http://services.service.WebService.org/", className = "org.webservice.service.services.MarkBorrowAsExtendedResponse")
    @Action(input = "http://services.service.WebService.org/BorrowService/markBorrowAsExtendedRequest", output = "http://services.service.WebService.org/BorrowService/markBorrowAsExtendedResponse")
    public void markBorrowAsExtended(
        @WebParam(name = "arg0", targetNamespace = "")
        Borrow arg0);

}
