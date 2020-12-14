package com.yuxin.project.world.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuxin.project.world.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> selectUsers();
}
