package com.zj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public abstract class IndexService{
/*    @Autowired
    IndexDao dao;*/
    public void service(){
        System.out.println("Service"+this.hashCode());
        System.out.println("dao"+getDao().hashCode());
        getDao().test();
    }
    @Lookup
    public abstract IndexDao getDao();
    /*    public void setIndexDaoImpl(IndexDao indexDaoImpl) {
        this.indexDaoImpl = indexDaoImpl;
    }*/
}
