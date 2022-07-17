package com.ycz.test;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-06-16:08
 * @Version: V1.0
 **/
public class OuterClass2 {
    private String outerName;

    public void display(){
        class InnerClass2{
            public void display(){
                System.out.println("method inner class");
            }
        }
        InnerClass2 innerClass2 = new InnerClass2();
        innerClass2.display();
    }

    public static void main(String[] args) {
        OuterClass2 outerClass = new OuterClass2();
        outerClass.display();
    }


}
