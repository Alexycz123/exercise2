package com.ycz;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-30-21:31
 * @Version: V1.0
 **/
public class SellTicket {

    public static Integer ticket  = 1000;

    public  static  final Object object = new Object();



    @Test
    public void sync(){
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    synchronized (object){
                        if (ticket>0){
                            System.out.println(Thread.currentThread().getName() + "卖了，剩余 " + ticket--);
                        }else{
                            System.out.println("卖完了");
                        }
                    }

                }

            }).start();
        }
    }


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    lock.lock();
                    try {
                        if (ticket>0){
                            System.out.println(Thread.currentThread().getName() + "卖了，剩余 " + --ticket);
                        }else{
                            System.out.println("卖完了");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    } finally{
                        lock.unlock();
                    }



                }

            }).start();
        }
    }



}
