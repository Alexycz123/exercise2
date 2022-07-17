package com.ycz;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-03-21:27
 * @Version: V1.0
 **/
public class OrderService {
    private final static OrderService instance = new OrderService();

    public static OrderService getInstance() {
        System.out.println("开始创建了");
        return instance;
    }
}
