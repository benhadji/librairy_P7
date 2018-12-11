package org.WebService.business.impl.manager;

import org.WebService.business.AbstractManager;
import org.WebService.business.contract.manager.UserManager;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.webservice.service.services.UserAccount;


public class UserManagerImpl extends AbstractManager implements UserManager {



    @Override
    public UserAccount getUserByEmail(String email) {
        return getDaoFactory().getUserDAO().getUserByEmail(email);
    }

    @Override
    public String hashPassword(String password) {

        String salt = BCrypt.gensalt();
        String passwordHash = BCrypt.hashpw(password, salt);

        return passwordHash;

    }

    @Override
    public UserAccount getloginUSer(String email) {
        UserAccount user = new UserAccount();

        try{
            user = getDaoFactory().getUserDAO().getUserByEmail(email);
        }catch(EmptyResultDataAccessException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean validateLogin(UserAccount utilisateur, String password) {

        boolean passwordChecked = false;

        if(utilisateur.getPassword() == null || !utilisateur.getPassword().startsWith("$2a$")){
            System.out.println();
            throw new IllegalArgumentException("Le hash password n'est pas valide");
        }

        passwordChecked = BCrypt.checkpw(password, utilisateur.getPassword());

        return passwordChecked;


    }


    @Override
    public String signupNewSubscriber(UserAccount user) {

        String encryptedPassword= hashPassword(user.getPassword());
        user.setPassword(encryptedPassword);
        getDaoFactory().getUserDAO().create(user);

        return "success";


    }

    @Override
    public void updateUser(UserAccount user) {
        getDaoFactory().getUserDAO().updateUser(user);
    }


}
