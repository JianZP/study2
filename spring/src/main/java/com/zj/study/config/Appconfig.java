package com.zj.study.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@ComponentScan(value = "com.zj")
public class Appconfig {
    @Bean
    @Autowired
    public SqlSessionFactoryBean  sqlSessionFactoryBean(DataSource dataSource){
       SqlSessionFactoryBean sqlSessionFactoryBean =  new SqlSessionFactoryBean();
       sqlSessionFactoryBean.setDataSource(dataSource);
       return sqlSessionFactoryBean;
    }
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("admin");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/ssh");
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return driverManagerDataSource;

    }
}
/*,excludeFilters = @Filter(type = FilterType.REGEX,pattern = "com.zj.study.service.*")
* 这是一个过滤器
* */
