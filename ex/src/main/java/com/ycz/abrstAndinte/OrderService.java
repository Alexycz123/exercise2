package com.ycz.abrstAndinte;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-03-21:31
 * @Version: V1.0
 **/

/**
 * 1、可以有普通方法
 * 2、不能有默认方法
 * 3、可以有常量，可以有变量
 * 4、继承抽象，单继承
 * 5、都不能实例化 ,但抽象类有构造方法
 * 6、定义抽象方法的时候，不能用private定义，其他都行
 * 7、可以有main方法
 * 8、都可以有静态方法
 */
public abstract class  OrderService {
    public static final String  c1 = "asdasd";



    private int a;

    public int b;

    public static void main(String[] args) {
        System.out.println("asdas");
    }
    protected int c;

    protected abstract void get5();
    abstract void get6();

    private void get(){

    }

    public void set(){

    }

    protected void get1(){

    }
    public void get2(){

    }
    public OrderService(){

    }
    public OrderService(int a,int b, int c){
        this.a = a;
        this.b =b;
        this.c = c;
    }

    public static void get10(){

    };

}
