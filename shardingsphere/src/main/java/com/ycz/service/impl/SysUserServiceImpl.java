package com.ycz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ycz.entity.SysUser;
import com.ycz.mapper.SysUserMapper;
import com.ycz.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-23-11:12
 * @Version: V1.0
 **/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper , SysUser> implements SysUserService {
}
