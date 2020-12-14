package com.yuxin;

import org.junit.jupiter.api.Test;

public class SecondTest {

    @Test
    void test() {
        Status[] values = Status.values();
        for (Status value : values) {
            System.out.println(value);
        }
    }

}
