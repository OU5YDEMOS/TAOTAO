package com.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Students implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private Integer classId;

    private Classes classesClassId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setClassesClassId(Classes classesClassId) {
        this.classesClassId=classesClassId;
    }

    public Classes getClassesClassId() {
        return classesClassId;
    }
}