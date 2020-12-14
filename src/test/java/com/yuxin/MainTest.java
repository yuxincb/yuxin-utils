package com.yuxin;

import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void test() {
        System.out.println(Status.SUCCESS);
    }

}

enum Status {

    SUCCESS(200), FAIL(500);

    private final int code;

    Status(int code) {
        this.code = code;
    }

    public int status() {
        return code;
    }

}
