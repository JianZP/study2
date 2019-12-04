package com.zj.study.dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
@Profile("dao1")
public class IndexDaoImpl  implements IndexDao{
    public IndexDaoImpl(){
        System.out.println("Constructor");
    }
    @PostConstruct
    public void init(){
        System.out.println("类初始化");
    }
}
