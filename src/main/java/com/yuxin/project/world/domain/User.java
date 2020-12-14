package com.yuxin.project.world.domain;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private Integer id;
    private String name;
    private Byte sex;
    private Integer age;
}
