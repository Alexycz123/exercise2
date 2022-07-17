package com.ycz;

import org.junit.platform.commons.function.Try;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-30-21:46
 * @Version: V1.0
 **/
public class syncAndNofity {
    public static void main(String[] args) {
        Resources resources = new Resources();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    resources.addOne2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                try {
                    resources.subOne2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
class Resources{
    private int number = 0;
    public final Object object = new Object();

    private final Lock lock=new ReentrantLock();

    private final Condition condition=lock.newCondition();
    public  synchronized void addOne() throws InterruptedException {
            if (number == 0){
                number++;
                System.out.println("现在结果为0，我要增加了");
                notifyAll();
            }else{
                this.wait();
            }
    }
    public synchronized void subOne() throws InterruptedException {

            if (number==1){

                number--;
                System.out.println("现在结果为1，我要减少了");
                notifyAll();
            }else{
                this.wait();
            }

    }


    public void addOne2() throws InterruptedException {
        lock.lock();
        try{
            if (number == 0){
                number++;
                System.out.println("现在结果为0，我要增加了");
                condition.signalAll();
            }else{
                condition.await();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public  void subOne2() throws InterruptedException {
        lock.lock();
        try{
            if (number==1){

                number--;
                System.out.println("现在结果为1，我要减少了");
                condition.signalAll();
            }else{
               condition.await();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

}
