package com.zj.study.test;

import com.zj.study.appconfig.Appconfig;
import com.zj.study.dao.Dao;
import com.zj.study.dao.IndexDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(Appconfig.class);
        Dao dao=(Dao) annotationConfigApplicationContext.getBean("indexDao");
        dao.query(2);
        dao.querya();
        /**
         * 生成代理对象
         */
    /*  Class<?>[] interfaces=new Class[]{Dao.class};
        byte bytes[]= ProxyGenerator.generateProxyClass("zjStudy",interfaces);
        File file=new File("test.class");
        try {
           FileOutputStream fo=new FileOutputStream(file);
            fo.write(bytes);
            fo.flush();
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
