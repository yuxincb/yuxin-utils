package com.yuxin.project.logger;

import com.yuxin.project.logger.instance.Person;
import com.yuxin.project.logger.instance.Student;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonLogger {

    private final Log log = LogFactory.getLog(getClass());

    public static void main(String[] args) {
        CommonLogger logger = new CommonLogger();
        logger.printLog();
        logger.log.info("-------------------------");
        logger.question();
        logger.log.info("-------------------------");
        Person person = new Person();
        person.work();
        Student student = new Student();
        student.work();
    }

    private void printLog() {
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warning");
        log.error("error");
        log.fatal("fatal");
    }

    private void question() {
        try {
            int x = 1/0;
            System.out.println(x);
        } catch (Exception e) {
            log.error("low-level error", e);
        }
    }

}
