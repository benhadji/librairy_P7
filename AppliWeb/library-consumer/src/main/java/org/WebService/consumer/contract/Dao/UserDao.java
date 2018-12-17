package org.WebService.consumer.contract.Dao;


import org.webservice.service.services.UserAccount;

public interface UserDao {

    UserAccount getUserByEmail(String email);
    UserAccount loginUSer(String email, String password);
    void create(UserAccount user);

    void updateUser(UserAccount user);
}
