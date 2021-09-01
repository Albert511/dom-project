package com.dom.frank.common;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * @description: 加载配置信息
 * @author: Dom Frank
 * @create: 2021/09/01 09:41
 */
public class LoadConfig {

    private static final String CONFIG_FILE_NAME = "test.loadconfig.properties";

    public Properties getConfigProperties(String path) {
        Properties properties = new Properties();
        InputStream inputStream;

        try {
            inputStream = new BufferedInputStream(new FileInputStream(path));
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    public Properties getConfigProperties() {
        Properties properties = new Properties();
        List<URL> list = new ArrayList();
        ClassLoader classloader = getCurrentClassloader();

        InputStream in = null;
        try {
            Enumeration<URL> resources = classloader.getResources(CONFIG_FILE_NAME);
            if (null != resources) {
                while (resources.hasMoreElements()) {
                    list.add(resources.nextElement());
                }

                for (URL url : list) {
                    in = url.openStream();
                    properties.load(in);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                    in = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return properties;
    }


    public ClassLoader getCurrentClassloader() {

        ClassLoader classLoader;
        classLoader = Thread.currentThread().getContextClassLoader();

        if (classLoader == null) {
            classLoader = LoadConfig.class.getClassLoader();
        }
        return classLoader;
    }
}
