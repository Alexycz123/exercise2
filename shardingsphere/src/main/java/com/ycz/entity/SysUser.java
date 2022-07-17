package com.ycz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-23-11:08
 * @Version: V1.0
 **/
@Data
@Accessors(chain = true)
@TableName(value = "sys_user")
public class SysUser {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String username;

    private Integer age;

    private String password;

    private String address;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

}
