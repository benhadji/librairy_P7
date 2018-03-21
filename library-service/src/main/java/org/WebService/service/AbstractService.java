package org.WebService.service;

import org.WebService.business.contract.manager.ManagerFactory;

public abstract class AbstractService {


    private static ManagerFactory managerFactory;

    protected static ManagerFactory getManagerFactory() {
        return managerFactory;
    }
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }


}