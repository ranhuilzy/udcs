package com.rh.udcs.web.main;

import com.rh.udcs.web.base.BootAppMainStrap;
import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class BootAppMain {
    //启动时不能直接执行main
    public static void main(String[] args) {
        SpringApplicationBuilder appBuilder=new SpringApplicationBuilder();
        appBuilder.sources(BootAppMainStrap.class);
        appBuilder.profiles("local");
        appBuilder.bannerMode(Banner.Mode.OFF);
        appBuilder.run(args);
    }
}
