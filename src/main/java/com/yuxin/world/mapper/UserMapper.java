package com.yuxin.world.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuxin.world.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}