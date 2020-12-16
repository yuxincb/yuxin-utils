package com.yuxin.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件读取公共类
 */
public class PropertiesUtils {

    private static Properties props;

    private PropertiesUtils() {
    }

    static {
        readProperties();
    }

    /**
     * 加载配置文件
     */
    private static void readProperties() {
        InputStream is = null;
        try {
            props = new Properties();
            is = PropertiesUtils.class.getResourceAsStream("/config.properties");
            props.load(is);
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

}
