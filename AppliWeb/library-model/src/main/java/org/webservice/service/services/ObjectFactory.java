
package org.webservice.service.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.webservice.service.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListResaByBookResponse_QNAME = new QName("http://services.service.WebService.org/", "listResaByBookResponse");
    private final static QName _AddReservationResponse_QNAME = new QName("http://services.service.WebService.org/", "addReservationResponse");
    private final static QName _DeleteReservation_QNAME = new QName("http://services.service.WebService.org/", "deleteReservation");
    private final static QName _ListResaByUserResponse_QNAME = new QName("http://services.service.WebService.org/", "listResaByUserResponse");
    private final static QName _UpdateReservationResponse_QNAME = new QName("http://services.service.WebService.org/", "updateReservationResponse");
    private final static QName _AddReservation_QNAME = new QName("http://services.service.WebService.org/", "addReservation");
    private final static QName _ListResaByBook_QNAME = new QName("http://services.service.WebService.org/", "listResaByBook");
    private final static QName _DeleteReservationResponse_QNAME = new QName("http://services.service.WebService.org/", "deleteReservationResponse");
    private final static QName _ListResaByUser_QNAME = new QName("http://services.service.WebService.org/", "listResaByUser");
    private final static QName _UpdateReservation_QNAME = new QName("http://services.service.WebService.org/", "updateReservation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.webservice.service.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddReservation }
     * 
     */
    public AddReservation createAddReservation() {
        return new AddReservation();
    }

    /**
     * Create an instance of {@link ListResaByBook }
     * 
     */
    public ListResaByBook createListResaByBook() {
        return new ListResaByBook();
    }

    /**
     * Create an instance of {@link DeleteReservationResponse }
     * 
     */
    public DeleteReservationResponse createDeleteReservationResponse() {
        return new DeleteReservationResponse();
    }

    /**
     * Create an instance of {@link ListResaByUserResponse }
     * 
     */
    public ListResaByUserResponse createListResaByUserResponse() {
        return new ListResaByUserResponse();
    }

    /**
     * Create an instance of {@link UpdateReservationResponse }
     * 
     */
    public UpdateReservationResponse createUpdateReservationResponse() {
        return new UpdateReservationResponse();
    }

    /**
     * Create an instance of {@link UpdateReservation }
     * 
     */
    public UpdateReservation createUpdateReservation() {
        return new UpdateReservation();
    }

    /**
     * Create an instance of {@link ListResaByUser }
     * 
     */
    public ListResaByUser createListResaByUser() {
        return new ListResaByUser();
    }

    /**
     * Create an instance of {@link DeleteReservation }
     * 
     */
    public DeleteReservation createDeleteReservation() {
        return new DeleteReservation();
    }

    /**
     * Create an instance of {@link ListResaByBookResponse }
     * 
     */
    public ListResaByBookResponse createListResaByBookResponse() {
        return new ListResaByBookResponse();
    }

    /**
     * Create an instance of {@link AddReservationResponse }
     * 
     */
    public AddReservationResponse createAddReservationResponse() {
        return new AddReservationResponse();
    }

    /**
     * Create an instance of {@link Editor }
     * 
     */
    public Editor createEditor() {
        return new Editor();
    }

    /**
     * Create an instance of {@link Author }
     * 
     */
    public Author createAuthor() {
        return new Author();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

    /**
     * Create an instance of {@link UserAccount }
     * 
     */
    public UserAccount createUserAccount() {
        return new UserAccount();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListResaByBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "listResaByBookResponse")
    public JAXBElement<ListResaByBookResponse> createListResaByBookResponse(ListResaByBookResponse value) {
        return new JAXBElement<ListResaByBookResponse>(_ListResaByBookResponse_QNAME, ListResaByBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "addReservationResponse")
    public JAXBElement<AddReservationResponse> createAddReservationResponse(AddReservationResponse value) {
        return new JAXBElement<AddReservationResponse>(_AddReservationResponse_QNAME, AddReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "deleteReservation")
    public JAXBElement<DeleteReservation> createDeleteReservation(DeleteReservation value) {
        return new JAXBElement<DeleteReservation>(_DeleteReservation_QNAME, DeleteReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListResaByUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "listResaByUserResponse")
    public JAXBElement<ListResaByUserResponse> createListResaByUserResponse(ListResaByUserResponse value) {
        return new JAXBElement<ListResaByUserResponse>(_ListResaByUserResponse_QNAME, ListResaByUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "updateReservationResponse")
    public JAXBElement<UpdateReservationResponse> createUpdateReservationResponse(UpdateReservationResponse value) {
        return new JAXBElement<UpdateReservationResponse>(_UpdateReservationResponse_QNAME, UpdateReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "addReservation")
    public JAXBElement<AddReservation> createAddReservation(AddReservation value) {
        return new JAXBElement<AddReservation>(_AddReservation_QNAME, AddReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListResaByBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "listResaByBook")
    public JAXBElement<ListResaByBook> createListResaByBook(ListResaByBook value) {
        return new JAXBElement<ListResaByBook>(_ListResaByBook_QNAME, ListResaByBook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "deleteReservationResponse")
    public JAXBElement<DeleteReservationResponse> createDeleteReservationResponse(DeleteReservationResponse value) {
        return new JAXBElement<DeleteReservationResponse>(_DeleteReservationResponse_QNAME, DeleteReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListResaByUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "listResaByUser")
    public JAXBElement<ListResaByUser> createListResaByUser(ListResaByUser value) {
        return new JAXBElement<ListResaByUser>(_ListResaByUser_QNAME, ListResaByUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "updateReservation")
    public JAXBElement<UpdateReservation> createUpdateReservation(UpdateReservation value) {
        return new JAXBElement<UpdateReservation>(_UpdateReservation_QNAME, UpdateReservation.class, null, value);
    }

}
