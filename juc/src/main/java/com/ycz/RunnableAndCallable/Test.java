package com.ycz.RunnableAndCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-03-18:30
 * @Version: V1.0
 **/
public class Test {
    public static void main(String[] args) throws Exception {
        new Thread(new RunnableTemp() , "ab").start();
        FutureTask<Integer> future = new FutureTask<Integer>(new CallableTemp());
        new Thread(future , "a").start();
        System.out.println(future.get());



    }
}

class RunnableTemp implements Runnable{

    @Override
    public void run() {
        System.out.println("run");
    }
}

class CallableTemp implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 100;
    }
}
