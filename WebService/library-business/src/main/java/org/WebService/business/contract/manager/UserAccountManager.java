package org.WebService.business.contract.manager;

import org.WebService.model.UserAccount;

public interface UserAccountManager {

    void createUser(UserAccount user);
    void updateUser(UserAccount user);
    boolean validateLogin (UserAccount userAccount, String password);
    UserAccount displayUser(String email);




}
