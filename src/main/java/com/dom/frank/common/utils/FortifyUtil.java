package com.dom.frank.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 过滤敏感信息
 * @author: Dom Frank
 * @create: 2021/09/01 09:52
 */
public class FortifyUtil {

    public static final Logger LOG = LoggerFactory.getLogger(FortifyUtil.class);

    private static Method getMessageMethod;

    private static Method getLocalizedMessageMethod;

    private static Method printStackTraceMethod;

    static {
        try {
            getMessageMethod = Throwable.class.getMethod("getMessage");
            getLocalizedMessageMethod = Throwable.class.getMethod("getLocalizedMessage");
            printStackTraceMethod = Throwable.class.getMethod("printStackTrace", PrintWriter.class);
        } catch (NoSuchMethodException e) {
            LOG.error("Init FortifyUtil error.exception:{}", e.getClass().getSimpleName());
        }
    }

    /**
     * 获取异常message，直接调用getMessage，fortify会报安全问题
     *
     * @param e 异常
     * @return 异常message
     */
    public static String getErrorMsg(Throwable e) {
        if (e == null) {
            return "";
        }
        try {
            return (String) getMessageMethod.invoke(e);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            LOG.error("Invoke exception message failed.exception:{}", e.getClass().getSimpleName());
        }
        return "";
    }

    /**
     * 获取异常LocalMessage
     *
     * @param e 异常
     * @return 异常LocalMessage
     */
    public static String getLocalizedMessage(Throwable e) {
        if (e == null) {
            return "";
        }
        try {
            return (String) getLocalizedMessageMethod.invoke(e);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            LOG.error("Invoke exception local message failed.exception:{}", e.getClass().getSimpleName());
        }
        return "";
    }

}
