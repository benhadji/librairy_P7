package org.WebService.business.impl.manager;

import org.WebService.business.contract.manager.UserAccountManager;
import org.WebService.model.UserAccount;
import org.springframework.security.crypto.bcrypt.BCrypt;


public class UserAccountManagerImpl extends AbstractManagerImpl implements UserAccountManager {


    @Override
    public void createUser(UserAccount user) {
        getDaoFactory().getUserAccountDAO().create(user);
    }

    @Override
    public void updateUser(UserAccount user) {
        getDaoFactory().getUserAccountDAO().update(user);

    }

    @Override
    public boolean validateLogin(UserAccount user, String password) {
        boolean passwordChecked = false;

        if(user.getPassword() == null || !user.getPassword().startsWith("$2a$")){
            throw new IllegalArgumentException("Le hash password n'est pas valide");
        }

        passwordChecked = BCrypt.checkpw(password, user.getPassword());

        return passwordChecked;
    }

    @Override
    public UserAccount displayUser(String email) {
        return getDaoFactory().getUserAccountDAO().getByEmail(email);
    }


}
