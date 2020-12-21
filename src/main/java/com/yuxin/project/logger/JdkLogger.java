package com.yuxin.project.logger;

import java.util.logging.Logger;

public class JdkLogger {

    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
        logger.finest("all things fine");
        logger.finer("most things fine");
        logger.fine("nothing to show");
        logger.config("config log");
        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.severe("process will be terminated...");
    }

}
