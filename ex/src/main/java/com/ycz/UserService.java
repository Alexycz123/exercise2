package com.ycz;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-03-21:23
 * @Version: V1.0
 **/
public class UserService {

    public static UserService instance;

    public static synchronized UserService getInstance(){
        if (instance==null){
            instance = new UserService();
        }
        return instance;
    }

}
