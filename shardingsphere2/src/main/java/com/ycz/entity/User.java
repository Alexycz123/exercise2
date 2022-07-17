package com.ycz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Builder;
import lombok.Data;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-23-17:48
 * @Version: V1.0
 **/
@Data
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    private String name;
    private Integer age;
}
