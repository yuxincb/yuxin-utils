package com.yuxin.project.logger.instance;

import lombok.extern.log4j.Log4j;

@Log4j
public class Student extends Person {

    @Override
    public void work() {
        logger.info("go to school");
    }

    @Override
    public void study() {
        log.info("studying in school");
    }

}
