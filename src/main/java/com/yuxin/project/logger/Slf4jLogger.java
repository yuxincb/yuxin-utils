package com.yuxin.project.logger;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Slf4jLogger {

    public static void main(String[] args) {
        log.info("static main");
        log.info("------------------------------");
        Slf4jLogger logger = new Slf4jLogger();
        logger.printLog();
    }

    private void printLog() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warning");
        log.error("error");
    }

}
