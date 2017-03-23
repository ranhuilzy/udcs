package com.rh.udcs.web.base;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

/**
 * SpringBoot启动实体对象
 * Created by hui.ran on 2017/3/14.
 */
@SpringBootApplication(scanBasePackages="com.rh.udcs")
public class BootAppMainStrap extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //这里的配置与com.jadyer.demo.test.ApiBootStarp.java中的配置是没有关系的
         builder.sources(this.getClass());
        return builder;
    }

    @Bean
    public Filter characterEncodingFilter(){
        return new CharacterEncodingFilter("UTF-8", true);
    }
}
