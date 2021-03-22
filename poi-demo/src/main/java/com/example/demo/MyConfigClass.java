package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author 枯萎花一朵
 * 创建时间：2018年12月26日,上午11:23:45
 * @Title: MyConfigClass.java
 * @Package com.aaa
 * @Description:拦截器配置
 */
@SpringBootConfiguration//标记此类为配置类
public class MyConfigClass extends WebMvcConfigurerAdapter {
    final String[] notLoginInterceptor = {"/emp/toList", "/dept/login", "/static/**"};
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(notLoginInterceptor);
        super.addInterceptors(registry);
    }

}
