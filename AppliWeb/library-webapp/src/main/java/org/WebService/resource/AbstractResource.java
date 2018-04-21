package org.WebService.resource;

import com.opensymphony.xwork2.ActionSupport;
import org.WebService.business.contract.manager.ManagerFactory;

public abstract class AbstractResource extends ActionSupport {

    private static ManagerFactory managerFactory;

    protected static ManagerFactory getManagerFactory() {
        return managerFactory;
    }
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }


}
