package com.yuxin.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 配置文件读取公共类
 */
public class PropertiesUtils {

    private static Properties props;

    private PropertiesUtils() {
    }

    /**
     * 初始化配置文件
     *
     * @param path 配置文件路径
     */
    public static void init(String path) {
        readProperties(path);
    }

    /**
     * 加载配置文件
     *
     * @param path 配置文件路径
     */
    private static void readProperties(String path) {
        InputStream is = null;
        try {
            props = new Properties();
            is = PropertiesUtils.class.getResourceAsStream("/" + path);
            props.load(is);
        } catch (NullPointerException e) {
            throw new NullPointerException("Properties file is not exist!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(is);
        }
    }

    /**
     * 关闭流
     *
     * @param is 输入流
     */
    private static void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据key值获取属性
     *
     * @param key 键
     * @return 属性值
     */
    public static String getValue(String key) {
        return props.getProperty(key);
    }

    /**
     * 获取全部属性
     *
     * @return 全部属性
     */
    public static Map<String, String> getAllProperties() {
        Map<String, String> properties = new HashMap<>();
        Enumeration<?> enu = props.propertyNames();
        while (enu.hasMoreElements()) {
            String key = (String) enu.nextElement();
            String value = props.getProperty(key);
            properties.put(key, value);
        }
        return properties;
    }

}
