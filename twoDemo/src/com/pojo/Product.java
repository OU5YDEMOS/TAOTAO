package com.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {
    private Long id;

    private String productname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
}