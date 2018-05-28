package com.sunshine.java8;

import java.io.Serializable;
import java.util.Optional;

/**
 * @Description:
 * @Author:
 * @Date: 2018-05-28 18:06
 **/
public class User implements Serializable{

    /** 用户编号 */
    private long id;

    private String name;

    private int age;

    private Optional<Long> phone;

    private Optional<String> email;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 省略setter和getter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Optional<Long> getPhone() {
        return phone;
    }

    public void setPhone(Optional<Long> phone) {
        this.phone = phone;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }
}
