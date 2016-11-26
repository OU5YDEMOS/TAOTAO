package com.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@SuppressWarnings("serial")
public class Ordermain implements Serializable {
    private Long id;

    private String custname;

    private String address;

    private String telphone;

    private Date senddate;

    private Set<Orderdetail> orderdetailsOrdermainid = new HashSet<Orderdetail>();;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public void setOrderdetailsOrdermainid(Set<Orderdetail> orderdetailsOrdermainid) {
        this.orderdetailsOrdermainid=orderdetailsOrdermainid;
    }

    public Set<Orderdetail> getOrderdetailsOrdermainid() {
        return orderdetailsOrdermainid;
    }
}