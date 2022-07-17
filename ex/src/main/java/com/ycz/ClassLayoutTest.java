package com.ycz;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-07-17:13
 * @Version: V1.0
 **/
public class ClassLayoutTest {
    private static  class T{
//            int i;
//            int m;
//            String abc= "asdasdasdasd";
//            boolean b;

    }
    public static void main(String[] args) throws InterruptedException {
//        Thread.sleep(5000);
        T t = new T();
        //启动了偏向锁
        System.out.println(ClassLayout.parseInstance(t).toPrintable());

        synchronized (t){
            System.out.println(ClassLayout.parseInstance(t).toPrintable());
        }



//        ReentrantLock lock = new ReentrantLock();

//
//        System.out.println(ClassLayout.parseInstance(t).toPrintable());

    }
}


