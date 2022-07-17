package com.ycz;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-03-21:26
 * @Version: V1.0
 **/
public class Test {
    public static void main(String[] args) {
        UserService userService = UserService.getInstance();

        UserService userService1 = UserService.getInstance();

        System.out.println(userService);
        System.out.println(userService1);


    }
}
