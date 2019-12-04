package com.zj.study.test;

import com.zj.study.entity.CityEnyity;
import com.zj.study.util.CommUtil;

public class Test {
    public static void main(String[] args) {
        CityEnyity cityEnyity=new CityEnyity();
        cityEnyity.setId("XXX");
        cityEnyity.setName("张三");
        String sql=CommUtil.bulidQuerySqlForEntity(cityEnyity);
        System.out.println(sql);
    }
}
