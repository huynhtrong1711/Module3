package com.codegym.model;

public class Product {
    private int id;
    private String nameProduct;
    private double price;
    private int amount;
    private String color;
    private String description;
    private int idCategory;
    private String nameCategory;

    public Product() {
    }

    public Product(String nameProduct, double price, int amount, String color,String description, int idCategory) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
        this.idCategory = idCategory;
    }

    public Product(int id, String nameProduct, double price, int amount, String color, int idCategory) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.idCategory = idCategory;
    }

    public Product(int id, String nameProduct, double price, int amount, String color, String description, int idCategory) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
        this.idCategory = idCategory;
    }

    public Product(int id, String nameProduct, double price, int amount, String color, int idCategory, String nameCategory) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
