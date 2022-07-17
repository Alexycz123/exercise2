package com.ycz.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ycz.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-03-20:05
 * @Version: V1.0
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {

   void insert2(@Param("tableName")String tableName , @Param("user") User user);

   List<User> selectUser(@Param("tableName")String tableName , @Param("orderByTemp")String orderByTemp);

}
