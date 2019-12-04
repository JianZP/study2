package com.zj.service;

import com.zj.dao.UserDao;

public class UserServiceImpl implements UserService{
    UserDao userDao;
//    public UserServiceImpl(UserDao userDao){
//            this.userDao=userDao;
//    }
    @Override
    public void find() {
        System.out.println("I am find!");
        userDao.query();
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
