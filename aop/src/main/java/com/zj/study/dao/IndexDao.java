package com.zj.study.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("indexDao")
public class IndexDao implements Dao{
    public void query(Integer a){
        System.out.println("query");
    }
    public void querya(){
        System.out.println("querya");
    }
}
