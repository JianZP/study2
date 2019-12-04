package com.zj.test;

import com.zj.Proxy.*;
import com.zj.dao.UserDao;
import com.zj.dao.UserDaoImpl;
import com.zj.util.TestCustomHandler;
import com.zj.util.UserInvocationHandler;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args){
        /*静态代理*/
//        UserDao target=new UserDaoTime(new UserDaoImpl());
//        UserDao proxy=new UserDaoLog(target);
//        proxy.query();
//        UserDaoImpl userDao=new UserDaoTimerLogPowerImpl();
//        UserDaoImpl dao=new UserDaoImpl();
//        userDao.query();
        /*自定义动态代理*/
//       UserDao proxy = (UserDao) ProxyUtil.newInstance(UserDao.class,new TestCustomHandler(new UserDaoImpl()));
//        try {
//            proxy.select();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        proxy.query();
      /*  JDK动态代理*/
        UserDao jdkProxy=(UserDao )Proxy.newProxyInstance(Test.class.getClassLoader(),new Class[]{UserDao.class},new UserInvocationHandler(new UserDaoImpl()));
        try {
            jdkProxy.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
