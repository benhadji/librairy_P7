package org.WebService.webapp.action;

import org.WebService.resource.AbstractResource;
import org.apache.struts2.interceptor.SessionAware;
import org.webservice.service.services.UserAccount;


import java.util.Map;

public class LogInAction extends AbstractResource implements SessionAware {

    private String email;
    private String password;
    private Map session;
    private UserAccount userAccount;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public Map getSession() {
        return session;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;

    }


    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String execute()
    {
        if(!session.containsKey("sessionUserAccount"))
        {
            if(email!=null)
            {
                userAccount = getManagerFactory().getUserAccountManager().getloginUSer(this.email);
                if(userAccount!=null && getManagerFactory().getUserAccountManager().validateLogin(userAccount,this.password))
                {
                    session.put("sessionUserAccount", getUserAccount());

                    return SUCCESS;
                }else{
                    setMessage("Email/Mot de passe incorrect");
                    return ERROR;
                }
            }else{
                return INPUT;
            }
        }else{
            return SUCCESS;
        }
    }

    public void validate()
    {
        if(this.email!=null)
        {
            if(this.email.equals("")) {
                addFieldError("email", "Le login est obligatoire");
            }
            if(!this.email.equals("") && this.email.length() <=2)
            {
                addFieldError("email", "Le login doit faire plus de deux caractères");
            }
        }
        if(this.password!=null)
        {
            if(this.password.equals(""))
            {
                addFieldError("password", "Le mot de passe ne peut être vide");
            }
            if(!this.password.equals("") && this.password.length()<5){
                addFieldError("password", "Le  mot de passe ne doit pas faire moins de cinq caractères");
            }
        }
    }


}
