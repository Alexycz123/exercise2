package com.ycz.entity;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-03-17:10
 * @Version: V1.0
 **/
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user01  = new User();
        user01.setUsername("abc");
        user01.setPassword("123456");
        User user02 = user01;
        System.out.println(user01);
        System.out.println(user02);
        //修改了username，看是否有所改变
        user01.setUsername("啊实打实大师多");
        System.out.println(user01.getUsername());
        System.out.println(user02.getUsername());




    }
}
