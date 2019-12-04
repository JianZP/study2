package com.zj.Proxy;

import com.zj.dao.UserDaoImpl;

public class UserDaoLogPowerImpl extends UserDaoLogImpl {
    @Override
    public void query() throws Exception{
        System.out.println("我是权限");
        super.query();
    }
}
