package org.WebService.business.impl.manager;

import org.WebService.consumer.contract.DaoFactory;

public abstract class AbstractManagerImpl {

    private DaoFactory daoFactory;

    protected DaoFactory getDaoFactory(){
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }





}
