package com.zj.Proxy;

import com.zj.dao.UserDaoImpl;

public class UserDaoPowerImpl extends UserDaoImpl {
    @Override
    public void query() throws Exception{
        System.out.println("我是权限");
        super.query();
    }
}
