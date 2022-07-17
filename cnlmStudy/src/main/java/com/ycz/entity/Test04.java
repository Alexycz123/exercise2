package com.ycz.entity;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-04-0:15
 * @Version: V1.0
 **/
public  class  Test04 {
    public static void main(String[] args) {
        User user = new User();
        User user02 = new User();

        System.out.println(user == user02);

        System.out.println(user);
        System.out.println(user02);

        System.out.println(user.equals(user02));
    }
}
