package org.WebService.webapp.action;

import org.WebService.resource.AbstractResource;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class HomeMembreAction extends AbstractResource implements SessionAware{

    private Map<String, Object> session;


    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


    public String execute(){
        if (!session.containsKey("sessionUserAccount")) {
            return ERROR;
        } else {
            return SUCCESS;
        }

    }


}
