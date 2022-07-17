package com.ycz.abrstAndinte;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-03-21:30
 * @Version: V1.0
 **/

import java.util.concurrent.ConcurrentHashMap;

/**
 * 1、不能有普通方法，可以有默认方法
 * 2、只能有public
 * 3、interface 只能有常量
 * 4、实现接口，多实现
 * 5、都不能实例化
 * 6、有main方法
 * 7、都可以有静态方法，必须有body
 */
public interface UserService {
    public  static  final  int a = 0;

    public abstract void get();

    public default void set(){

    }



    public static void main(String[] args) {

    }

    public static void get2(){
        System.out.println("asda");
    }
}
