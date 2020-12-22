package com.yuxin.project.logger;

import com.yuxin.project.logger.instance.Person;
import com.yuxin.project.logger.instance.Student;
import lombok.extern.log4j.Log4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Log4j
public class Log4jLogger {

    Log logger = LogFactory.getLog(getClass());

    public static void main(String[] args) {
        log.info("static main");
        log.info("------------------------------");
        Log4jLogger logger = new Log4jLogger();
        logger.factory();
        logger.printLog();
        log.info("------------------------------");
        Person person = new Person();
        Student student = new Student();
        person.study();
        student.study();
    }

    private void factory() {
        logger.info("from factory");
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
