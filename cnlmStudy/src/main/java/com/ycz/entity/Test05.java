package com.ycz.entity;

import java.lang.reflect.Constructor;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-04-23:17
 * @Version: V1.0
 **/
public class Test05 {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.ycz.entity.Peg");

        Class<Peg> pegClass = Peg.class;
        Peg peg = pegClass.newInstance();



        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        Peg peg1 = (Peg) o;
        peg1.setAge(18);
        System.out.println(peg1.getAge());


    }
}
