package org.WebService.service.services;

import org.WebService.model.UserAccount;
import org.WebService.service.AbstractService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "User")
public class UserService extends AbstractService{


    @WebMethod
    public UserAccount findUserByEmail(String email){
        return getManagerFactory().getUserAccountManager().displayUser(email);
    }

    @WebMethod
    public void createUser(UserAccount user)
    {
        getManagerFactory().getUserAccountManager().createUser(user);
    }

    @WebMethod
    public void updateUser(UserAccount user)
    {
        getManagerFactory().getUserAccountManager().updateUser(user);
    }

    @WebMethod
    public void validateLogin(UserAccount user, String password)
    {
        getManagerFactory().getUserAccountManager().validateLogin(user, password);
    }

}
