package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    void saveProduct(Product product);
    void updateProduct(Product product);
    Product findById(int id);
    void delete(int id);
    List<Product> searchByName(String name);
}
