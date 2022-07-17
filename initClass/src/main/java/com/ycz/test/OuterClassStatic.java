package com.ycz.test;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-06-16:11
 * @Version: V1.0
 **/
public class OuterClassStatic {
    private String outerName;

    public void display(){
        System.out.println("outer class display");
    }

    public static class InnerClassStatic{
        private String innerName;
        public InnerClassStatic(){
            innerName = "inner class";
        }
        public void display(){
            System.out.println("inner class display");
            System.out.println(innerName);
        }
    }

    public static void main(String[] args) {
        OuterClassStatic outerClassStatic = new OuterClassStatic();
        outerClassStatic.display();

        InnerClassStatic innerClassStatic = new InnerClassStatic();
        innerClassStatic.display();
    }
}
