package com.yuxin;

import com.yuxin.common.utils.PropertiesUtils;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class MainTest {

    @Test
    void test() {
        PropertiesUtils.init("ftp.properties");
        String port = PropertiesUtils.getValue("ftp.port");
        System.out.println(port);
        Map<String, String> properties = PropertiesUtils.getAllProperties();
        System.out.println(properties);
    }

}
