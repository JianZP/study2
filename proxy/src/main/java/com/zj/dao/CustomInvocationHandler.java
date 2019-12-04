package com.zj.dao;

import java.lang.reflect.Method;

public interface CustomInvocationHandler {
    public Object invoke(Method m);
}
