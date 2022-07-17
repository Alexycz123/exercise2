package com.ycz.test;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-06-16:29
 * @Version: V1.0
 **/
public class Test {
    public static void main(String[] args) {
        MyInterface myInterface = new MyImplement();
        myInterface.test();

        MyInterface myInterface1 = new MyInterface() {
            @Override
            public void test() {
                System.out.println("test2");
            }
        };

        myInterface1.test();

    }
}
