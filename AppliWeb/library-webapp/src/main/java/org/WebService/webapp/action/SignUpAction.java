package org.WebService.webapp.action;

import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
import org.WebService.resource.AbstractResource;
import org.webservice.service.services.UserAccount;

import java.util.Date;

public class SignUpAction extends AbstractResource {

    private UserAccount userAccount;
    private String firstName, lastName, email, password, passwordConfirmation;
    private String address, city, phoneNumber;
    private Date birthDate;
    private Integer postCode;

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @TypeConversion(converter = "StringToDateConverter")
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }


    public String execute() throws Exception {

        if(userAccount!=null){
            addActionMessage("L'utilisateur " + userAccount.getFirstName() +" "+ userAccount.getLastName()+ " a ete correctement enregistré !!" );
            return getManagerFactory().getUserAccountManager().signupNewSubscriber(userAccount);
        }
        else{
            return "input";
        }

    }




}
