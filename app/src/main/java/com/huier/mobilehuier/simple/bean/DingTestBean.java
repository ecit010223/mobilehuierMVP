package com.huier.mobilehuier.simple.bean;

/**
 * 作者：张玉辉
 * 时间：2017/10/9.
 */

public class DingTestBean {
    private String name;
    private int number;
    private String time;

    public DingTestBean(String name, int number, String time) {
        this.name = name;
        this.number = number;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
