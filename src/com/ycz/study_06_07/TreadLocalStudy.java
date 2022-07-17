package com.ycz.study_06_07;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-07-14:25
 * @Version: V1.0
 **/
public class TreadLocalStudy {
    private static ThreadLocal<Person> t1 = new ThreadLocal<>();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                Thread.sleep(1000);
                t1.set(new Person("abc"));
                System.out.println(t1.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(2000);
//                t1.set(new Person("abc"));
                System.out.println(t1.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }


}


class Person{

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name){
        this.name= name;
    }
}
