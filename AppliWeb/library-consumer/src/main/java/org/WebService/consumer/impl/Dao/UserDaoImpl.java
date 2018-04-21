package org.WebService.consumer.impl.Dao;

import org.WebService.consumer.contract.Dao.UserDao;
import org.webservice.service.services.User;
import org.webservice.service.services.UserAccount;
import org.webservice.service.services.UserService;


public class UserDaoImpl implements UserDao {


    private User userService = new User();
    private UserService userSrv = userService.getUserServicePort();

    public User getUserService() {
        return userService;
    }

    public void setUserService(User userService) {
        this.userService = userService;
    }

    public UserService getUserSrv() {
        return userSrv;
    }

    public void setUserSrv(UserService userSrv) {
        this.userSrv = userSrv;
    }

    @Override
    public UserAccount getUserByEmail(String email) {
        return userSrv.findUserByEmail(email);
    }

    @Override
    public UserAccount loginUSer(String email, String password) {
        return null;
    }

    @Override
    public void create(UserAccount user) {

        userSrv.createUser(user);

    }
}
