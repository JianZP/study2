package com.zj.study.appconfig;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ZjAspectj {
    @Pointcut("execution(* com.zj.study.dao.*.*(..))")
    public void pointCutExecution(){
        System.out.println("point");
    }
    @Pointcut("within(com.zj.study.dao.*)")
    public void pointCutWithin(){
        System.out.println("point");
    }
    @Pointcut("args(Integer)")
    public void pointCutArgs(){
        System.out.println("point");
    }


    @Pointcut("@annotation(com.zj.study.anno.Zj)")
    public void pointCut(){
        System.out.println("point");
    }

    @Pointcut("this(com.zj.study.dao.IndexDao)")
    public void pointCutThis(){
        System.out.println("point");
    }
    /**
     * location
     * logic
     */
    @Before("pointCutThis()")
    public void before(){
        System.out.println("before");
    }
}
