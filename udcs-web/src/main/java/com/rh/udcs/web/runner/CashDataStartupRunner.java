package com.rh.udcs.web.runner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by hui.ran on 2017/3/22.
 */
@Component
@Order(value=1)
public class CashDataStartupRunner implements CommandLineRunner {
    protected  final static Logger logger= LoggerFactory.getLogger(CashDataStartupRunner.class);
    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        logger.info("开始加载相关的缓存数据***************");
    }
}
