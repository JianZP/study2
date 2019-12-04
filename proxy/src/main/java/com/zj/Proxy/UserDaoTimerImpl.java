package com.zj.Proxy;

import com.zj.dao.UserDaoImpl;

public class UserDaoTimerImpl extends UserDaoImpl {
    @Override
    public void query() throws Exception{
        System.out.println("运行了好久好久的");
        super.query();
    }
}
