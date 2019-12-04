package com.zj.test;

import com.zj.service.UserService;
import com.zj.service.UserServiceImpl;
import org.spring.util.BeanFactory;

public class Test {
    public static void main(String[] args) {
        BeanFactory beanFactory=new BeanFactory("spring.xml");
        UserService service=(UserService) beanFactory.getBean("service");
        service.find();
    }
}
