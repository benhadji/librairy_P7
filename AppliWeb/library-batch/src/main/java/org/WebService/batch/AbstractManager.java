package org.WebService.batch;

import org.WebService.business.contract.manager.ManagerFactory;

public class AbstractManager {

    private static ManagerFactory managerFactory;

    protected static ManagerFactory getManagerFactory() {
        return managerFactory;
    }

    public static void setManagerFactory(ManagerFactory managerFactory) {
        AbstractManager.managerFactory = managerFactory;
    }

}
