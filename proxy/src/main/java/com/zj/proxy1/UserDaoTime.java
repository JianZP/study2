package com.zj.proxy1;

import com.zj.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTime implements UserDao {
    @Autowired
    private UserDao dao;
    public UserDaoTime(UserDao userDao){
        this.dao=userDao;
    }
  /*  @Override
    public void query() throws Exception{
        System.out.println("Timer");
        dao.query();
    }*/

    @Override
    public String select() throws Exception{
        return null;
    }
}
