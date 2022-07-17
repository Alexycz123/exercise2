package com.ycz.entity;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-03-17:38
 * @Version: V1.0
 **/
public class Test03 {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User();
        user.setUsername("abc");
        user.setPassword("123456");
        Peg peg = new Peg();
        peg.setName("小狗");
        peg.setAge(18);
        user.setPeg(peg);



        //试一下深拷贝 , peg为浅拷贝
        User user02 = user;
        System.out.println(user02);
        System.out.println(user);

        System.out.println(user02.getPeg());
        System.out.println(user.getPeg());
        peg.setAge(20);
        System.out.println("user-->"+user.getPeg().getAge());
        System.out.println("user02-->"+user02.getPeg().getAge());

        user.setUsername("abvasda");

        System.out.println("user-->"+user.getUsername());
        System.out.println("user02-->"+user02.getUsername());

    }

}
