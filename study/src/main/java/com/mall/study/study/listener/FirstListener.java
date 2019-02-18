package com.mall.study.study.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Description
 * @Author Jiang
 * @Date 2018/12/6 11:28
 * @Version 1.0
 **/
@WebListener
@Slf4j
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("[listener init...]");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("[listener destroy...]");
    }
}
