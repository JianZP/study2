package com.zj.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*@Component("dao")*/
@Repository("dao")
@Scope("prototype")
public class IndexDaoImpl implements IndexDao{
    @Override
    public void test() {
        System.out.println("impl0");
    }
}
