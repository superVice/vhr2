


package com.zzyy.vhr.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = "com.zzyy.vhr.mapper",sqlSessionFactoryRef = "sqlSessionFactory1",
        sqlSessionTemplateRef = "sqlSessionTemplate1")
public class MybatisConfigOne {
    @Resource(name="dsOne")
    DataSource dsOne;

    @Bean
    SqlSessionFactory sqlSessionFactory1() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        try {
            bean.setDataSource(dsOne);
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    SqlSessionTemplate sqlSessionTemplate1(){
        return new SqlSessionTemplate(sqlSessionFactory1());
    }
}

