package com.hb.pojo;

import java.io.Serializable;
import java.util.Date;

public class Stu implements Serializable {
    private Integer id;
    private String name;
    private Date date;

    public Stu() {
    }

    public Stu(Integer id, String name, Date date) {
        this.name = name;
        this.id = id;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", date=" + date +
                '}';
    }
}
