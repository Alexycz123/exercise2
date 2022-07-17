package com.ycz;

import java.lang.reflect.ParameterizedType;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-30-22:01
 * @Version: V1.0
 **/
public class CommunicateLock {
    public static void main(String[] args) {
        Communication communication = new Communication();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    communication.firstE();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    communication.secendE();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    communication.thirdE();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}

class Communication{
    private static int flag = 1;
    private final Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void firstE() throws InterruptedException {
        lock.lock();
        try {
            if (flag==1){
                System.out.println("方法一开始执行");
                flag = 2;
                condition2.signal();
            }else {
                System.out.println("未到方法一开始执行");
                condition1.await();
            }
        }finally {
            lock.unlock();
        }

    }

    public void secendE() throws InterruptedException {
        lock.lock();
        try {
            if (flag == 2){
                System.out.println("方法二开始执行");
                flag=3;
                condition3.signal();
            }else{
                System.out.println("未到方法二开始执行");
                condition2.await();
            }
        }finally {
            lock.unlock();
        }
    }

    public void thirdE() throws InterruptedException{
        lock.lock();
        try {
            if (flag == 3){
                System.out.println("方法三开始执行");
                flag = 1;
                condition1.signal();
            }else{
                System.out.println("未到方法一开始执行");
                condition3.await();
            }
        }finally {
            lock.unlock();
        }
    }
}
