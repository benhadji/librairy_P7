package org.WebService.business.contract.manager;


import org.webservice.service.services.UserAccount;

public interface UserManager {

    UserAccount getUserByEmail(String email);
    String hashPassword(String password);
    UserAccount getloginUSer(String email);
    boolean validateLogin (UserAccount utilisateur, String password);
    String signupNewSubscriber(UserAccount user);
    void updateUser(UserAccount user);
}
