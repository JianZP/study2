package com.zj.study.appconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.zj")
@EnableAspectJAutoProxy(proxyTargetClass = false) //开启对AspectJ语法的支持 为true时使用jdk动态代理
public class Appconfig {
}
