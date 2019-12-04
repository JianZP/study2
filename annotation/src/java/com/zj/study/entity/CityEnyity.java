package com.zj.study.entity;

import com.zj.study.anno.Entity;

@Entity("city")
public class CityEnyity {

    private String id;
    private String name;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
