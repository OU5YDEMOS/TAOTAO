package com.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Orderdetail implements Serializable {
    private Long id;

    private Long ordermainid;

    private String productname;

    private Long num;

    private Double price;

    private Ordermain ordermainOrdermainid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdermainid() {
        return ordermainid;
    }

    public void setOrdermainid(Long ordermainid) {
        this.ordermainid = ordermainid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOrdermainOrdermainid(Ordermain ordermainOrdermainid) {
        this.ordermainOrdermainid=ordermainOrdermainid;
    }

    public Ordermain getOrdermainOrdermainid() {
        return ordermainOrdermainid;
    }
}