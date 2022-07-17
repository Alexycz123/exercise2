package com.ycz;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-06-17-1:32
 * @Version: V1.0
 **/
public class ThreadStudy extends Thread{

    private static  StringBuilder stringBuilder =  new StringBuilder();
    private Object o = new Object();

    @Override
    public void run() {
        synchronized (o){
            stringBuilder.append("啊阿三大苏打");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
         System.out.println(stringBuilder.length());
//            System.out.println(stringBuilder.toString());
        }



    }
}
