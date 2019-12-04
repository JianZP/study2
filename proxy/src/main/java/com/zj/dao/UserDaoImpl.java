package com.zj.dao;

public class UserDaoImpl implements UserDao{
    public void query()throws Exception{
        System.out.println("查询数据库");
    }

    @Override
    public String select() throws Exception{
        System.out.println("___________________");
        return null;
    }
}
