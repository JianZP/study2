package com.zj.proxy1;

import com.zj.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoLog implements UserDao {
    @Autowired
    private UserDao dao;
    public UserDaoLog(UserDao userDao){
        this.dao=userDao;
    }
 /*   @Override
    public void query() throws Exception{
        System.out.println("log");
        dao.query();
    }*/

    @Override
    public String select() throws Exception{
        return null;
    }
}
