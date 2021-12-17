package com.dom.jarvis.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: logback test
 * @author: Dom Frank
 * @create: 2021/12/17 15:58
 */
public class LogbackTest {
    public static final Logger LOG = LoggerFactory.getLogger(LogbackTest.class);

    public static void main(String[] args) {
        LOG.info("HELLO WORLD!!!");
        LOG.trace("日志的trace功能");
        LOG.debug("日志的debug功能");
        LOG.info("日志的info功能");
        LOG.warn("日志的warn功能");
        LOG.error("日志的error功能");
    }

}
