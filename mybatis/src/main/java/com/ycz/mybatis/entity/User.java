package com.ycz.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-03-20:02
 * @Version: V1.0
 **/
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String pwd;

    private String gender;

    private String qq;

    private Integer age;

    private String address;

    private String email;

    private Integer deleted;
}
