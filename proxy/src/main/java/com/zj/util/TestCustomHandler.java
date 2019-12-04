package com.zj.util;

import com.zj.dao.CustomInvocationHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCustomHandler implements CustomInvocationHandler {
    Object target;
    public TestCustomHandler(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Method m) {
        System.out.println("aaaaa");
        try {
            return  m.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
