package com.zj.study.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
@Primary //主数据元
@Profile("dao2")
public class IndexDaoImpl1 implements IndexDao{
    public IndexDaoImpl1(){
        System.out.println("Constructor1");
    }
    @PostConstruct
    public void init(){
        System.out.println("类初始化1");
    }
}
