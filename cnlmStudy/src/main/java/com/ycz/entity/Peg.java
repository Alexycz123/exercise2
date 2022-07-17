package com.ycz.entity;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-03-17:36
 * @Version: V1.0
 **/
public   class  Peg implements Cloneable{



    private String name;

    private Integer age;

    public Peg(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Peg() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
