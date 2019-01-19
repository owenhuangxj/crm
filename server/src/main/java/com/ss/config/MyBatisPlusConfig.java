package com.ss.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ss.dao")
public class MyBatisPlusConfig {

    /*
     * 注册分页插件==>mybatis分页必须配置，自动识别数据库类型
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

}
