package org.WebService.consumer.contract.DAO;

import org.WebService.model.UserAccount;

public interface UserAccountDAO {

    void create(UserAccount user);
    void update(UserAccount user);
    UserAccount getByEmail(String email);
    UserAccount findByLogin(String username);

}
