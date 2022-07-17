package com.ycz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycz.entity.SysUser;
import com.ycz.mapper.SysUserMapper;
import com.ycz.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-08-16:20
 * @Version: V1.0
 **/
@Service
public class UserServiceImpl
extends ServiceImpl<SysUserMapper , SysUser> implements IUserService
{
}
