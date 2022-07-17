package com.ycz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ycz.entity.User;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-23-17:50
 * @Version: V1.0
 **/
public interface IUserService extends IService<User> {
    Object pageAll(Integer pageNo, Integer pageSize);
}
