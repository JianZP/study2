package com.zj.Proxy;

import com.zj.dao.UserDaoImpl;

import javax.management.Query;

public class UserDaoLogImpl extends UserDaoImpl {
    @Override
    public void query() throws Exception{
        System.out.println("我是日志");
        super.query();
    }
}
