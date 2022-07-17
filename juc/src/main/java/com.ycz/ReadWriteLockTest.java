package com.ycz;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-01-23:47
 * @Version: V1.0
 **/
public class ReadWriteLockTest {
    public static void main(String[] args) {

        Book book = new Book();

            new Thread(()->{
                for (int i = 0; i < 5; i++) {
                    book.put(String.valueOf(i), "a");
                }
        },String.valueOf("aa")).start();



            new Thread(()->{
                for (int i = 0; i < 5; i++) {
                    book.get(String.valueOf(i));
                }
        },String.valueOf("bb")).start();

    }
}

class Book{
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Map<String ,String> map = new HashMap<>();
    public void put(String key , String value){
        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"正在进行写操作");

            map.put(key , value);
            System.out.println(Thread.currentThread().getName()+"写完了");

        }catch (Exception e){

        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        readWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"正在进行读操作");

            System.out.println(Thread.currentThread().getName()+map.get(key));

            System.out.println(Thread.currentThread().getName()+"读完了");

        }catch (Exception e){

        }finally {
            readWriteLock.readLock().unlock();
        }
    }


}
