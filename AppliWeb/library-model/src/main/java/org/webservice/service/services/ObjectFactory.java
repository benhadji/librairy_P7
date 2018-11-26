
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

    private final static QName _CreateUser_QNAME = new QName("http://services.service.WebService.org/", "createUser");
    private final static QName _ValidateLoginResponse_QNAME = new QName("http://services.service.WebService.org/", "validateLoginResponse");
    private final static QName _UpdateUser_QNAME = new QName("http://services.service.WebService.org/", "updateUser");
    private final static QName _ValidateLogin_QNAME = new QName("http://services.service.WebService.org/", "validateLogin");
    private final static QName _FindUserByEmail_QNAME = new QName("http://services.service.WebService.org/", "findUserByEmail");
    private final static QName _UpdateUserResponse_QNAME = new QName("http://services.service.WebService.org/", "updateUserResponse");
    private final static QName _FindUserByEmailResponse_QNAME = new QName("http://services.service.WebService.org/", "findUserByEmailResponse");
    private final static QName _CreateUserResponse_QNAME = new QName("http://services.service.WebService.org/", "createUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.webservice.service.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindUserByEmailResponse }
     * 
     */
    public FindUserByEmailResponse createFindUserByEmailResponse() {
        return new FindUserByEmailResponse();
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link UpdateUser }
     * 
     */
    public UpdateUser createUpdateUser() {
        return new UpdateUser();
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link ValidateLoginResponse }
     * 
     */
    public ValidateLoginResponse createValidateLoginResponse() {
        return new ValidateLoginResponse();
    }

    /**
     * Create an instance of {@link FindUserByEmail }
     * 
     */
    public FindUserByEmail createFindUserByEmail() {
        return new FindUserByEmail();
    }

    /**
     * Create an instance of {@link UpdateUserResponse }
     * 
     */
    public UpdateUserResponse createUpdateUserResponse() {
        return new UpdateUserResponse();
    }

    /**
     * Create an instance of {@link ValidateLogin }
     * 
     */
    public ValidateLogin createValidateLogin() {
        return new ValidateLogin();
    }

    /**
     * Create an instance of {@link UserAccount }
     * 
     */
    public UserAccount createUserAccount() {
        return new UserAccount();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "createUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "validateLoginResponse")
    public JAXBElement<ValidateLoginResponse> createValidateLoginResponse(ValidateLoginResponse value) {
        return new JAXBElement<ValidateLoginResponse>(_ValidateLoginResponse_QNAME, ValidateLoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "updateUser")
    public JAXBElement<UpdateUser> createUpdateUser(UpdateUser value) {
        return new JAXBElement<UpdateUser>(_UpdateUser_QNAME, UpdateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "validateLogin")
    public JAXBElement<ValidateLogin> createValidateLogin(ValidateLogin value) {
        return new JAXBElement<ValidateLogin>(_ValidateLogin_QNAME, ValidateLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserByEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "findUserByEmail")
    public JAXBElement<FindUserByEmail> createFindUserByEmail(FindUserByEmail value) {
        return new JAXBElement<FindUserByEmail>(_FindUserByEmail_QNAME, FindUserByEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "updateUserResponse")
    public JAXBElement<UpdateUserResponse> createUpdateUserResponse(UpdateUserResponse value) {
        return new JAXBElement<UpdateUserResponse>(_UpdateUserResponse_QNAME, UpdateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserByEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "findUserByEmailResponse")
    public JAXBElement<FindUserByEmailResponse> createFindUserByEmailResponse(FindUserByEmailResponse value) {
        return new JAXBElement<FindUserByEmailResponse>(_FindUserByEmailResponse_QNAME, FindUserByEmailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.service.WebService.org/", name = "createUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

}
