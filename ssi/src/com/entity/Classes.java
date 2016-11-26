package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Classes implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;

    private String name;

    private String beginDate;

    private String endDate;

    private Set<Students> studentssClassId = new HashSet<Students>(0);;

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

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStudentssClassId(Set<Students> studentssClassId) {
        this.studentssClassId=studentssClassId;
    }

    public Set<Students> getStudentssClassId() {
        return studentssClassId;
    }
}