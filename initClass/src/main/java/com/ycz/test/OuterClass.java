package com.ycz.test;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-06-15:53
 * @Version: V1.0
 **/
public class OuterClass {
    private String outerName;

    public void display(){
        System.out.println("OtherClass display");
        System.out.println(outerName);
    }
    public class  InnerClass{
        private String innerName;
        public void display(){
            System.out.println("innerClass");
            System.out.println(innerName);
        }
        public InnerClass(){
            innerName  = "inner Class";
        }
    }


    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.display();

        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        innerClass.display();
    }

}
