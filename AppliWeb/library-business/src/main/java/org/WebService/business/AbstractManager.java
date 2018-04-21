package org.WebService.business;

import org.WebService.consumer.contract.DaoFactory;

public abstract class AbstractManager {

    private DaoFactory daoFactory;

    protected DaoFactory getDaoFactory(){
        return daoFactory;
    }

    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }



}
