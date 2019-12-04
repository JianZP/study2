package com.zj.study.test;

import com.zj.study.config.Appconfig;
import com.zj.study.dao.IndexDao;
import com.zj.study.dao.IndexDaoImpl;
import com.zj.study.service.IndexService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles("dao1");
        applicationContext.register(Appconfig.class);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean(IndexDao.class).getClass().getName());
    }
}
