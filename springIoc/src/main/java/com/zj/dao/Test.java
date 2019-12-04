package com.zj.dao;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
       /* ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("classpath:spring.xml");*/
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(Spring.class);
       IndexService indexService=(IndexService) annotationConfigApplicationContext.getBean("indexService");
       indexService.service();
        System.out.println("--------------------");
        IndexService indexService1=(IndexService) annotationConfigApplicationContext.getBean("indexService");
        indexService1.service();
        System.out.println("--------------------");
        IndexService indexService2=(IndexService) annotationConfigApplicationContext.getBean("indexService");
        indexService2.service();
    }
}
