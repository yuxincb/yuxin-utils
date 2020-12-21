package com.yuxin.project.logger.instance;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Person {

    final Log logger = LogFactory.getLog(getClass());

    public void work() {
        logger.info("do something");
    }

}
