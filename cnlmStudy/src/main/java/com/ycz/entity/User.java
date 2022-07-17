package com.ycz.entity;

import java.util.Objects;

/**
 * @Description:
 * @Author: Alex
 * @Date 2022-07-03-17:08
 * @Version: V1.0
 **/
public class User implements Cloneable{


    private String username;

    private String password;

    private Peg peg;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Peg getPeg() {
        return peg;
    }

    public void setPeg(Peg peg) {
        this.peg = peg;
    }

    public String getPassword() {
        return password;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    public User() {
    }

    public User(String username, String password , Peg peg) {
        this.username = username;
        this.password = password;
        this.peg = peg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(peg, user.peg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, peg);
    }
}
