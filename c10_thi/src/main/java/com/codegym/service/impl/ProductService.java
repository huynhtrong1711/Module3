package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.repository.impl.ProductRepository;
import com.codegym.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        iProductRepository.saveProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        iProductRepository.updateProduct(product);
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void deleteProduct(int id) {
        iProductRepository.deleteProduct(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return iProductRepository.searchByName(name);
    }
}
