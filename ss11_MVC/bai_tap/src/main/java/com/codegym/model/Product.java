package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private String information;
    private String country;

    public Product() {
    }

    public Product(int id, String name, String information, String country) {
        this.id = id;
        this.name = name;
        this.information = information;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
