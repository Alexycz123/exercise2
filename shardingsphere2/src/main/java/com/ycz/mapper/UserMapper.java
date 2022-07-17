package com.ycz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ycz.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-23-17:49
 * @Version: V1.0
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> pageQuery(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
}
