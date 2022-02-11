package model;

import java.util.Date;

public class Customer {
    private String code;
    private String name;
    private String dateOB;
    private String address;
    private String picture;

    public Customer() {
    }

    public Customer(String code, String name, String dateOB, String address, String picture) {
        this.code = code;
        this.name = name;
        this.dateOB = dateOB;
        this.address = address;
        this.picture = picture;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOB() {
        return dateOB;
    }

    public void setDateOB(String dateOB) {
        this.dateOB = dateOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}



