package com.ycz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycz.entity.User;
import com.ycz.mapper.UserMapper;
import com.ycz.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-23-17:50
 * @Version: V1.0
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper , User> implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Object pageAll(Integer pageNo, Integer pageSize) {
        return userMapper.pageQuery(pageNo ,pageSize);
    }

    private Integer offset(Integer pageNo , Integer pageSize){
        if(pageSize == null || pageSize <= 0) {
            return 0;
        }
        return (pageSize - 1) * pageNo;
    }
}
