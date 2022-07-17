package com.ycz.entity;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-05-0:21
 * @Version: V1.0
 **/
public class Student extends User{
    @Override
    protected void setPassword(String password) {
        super.setPassword(password);
    }


}
