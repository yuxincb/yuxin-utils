package com.yuxin.project.logger.instance;

import lombok.extern.log4j.Log4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Log4j
public class Person {

    final Log logger = LogFactory.getLog(getClass());

    public void work() {
        logger.info("do something");
    }

    public void study() {
        log.info("studying in company");
    }

}
