package com.yuxin.project.logger;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Log4j2Logger {

    public static void main(String[] args) {
        Log4j2Logger logger = new Log4j2Logger();
        logger.printLog();
    }

    private void printLog() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warning");
        log.error("error");
        log.fatal("fatal");
    }

}
