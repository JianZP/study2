package com.zj.study.util;

import com.zj.study.anno.Entity;

public class CommUtil {
    /**
     * 通过一个对象构建一条查询的SQL语句
     * @param obj
     */
    public static String bulidQuerySqlForEntity(Object obj){
        Class clazz=obj.getClass();
        //判断是否加了注解
        if(clazz.isAnnotationPresent(Entity.class)){
        //得到注解
          Entity entity=(Entity) clazz.getAnnotation(Entity.class);
          //调用方法
           String entutyName = entity.value();
            System.out.println(entutyName);

        }
        String sql="select * from  where id='"+"'";
        return sql;
    }
}
