package com.codegym.service;

import com.codegym.model.Product;

import java.util.*;

public class ProductServiceImpl implements ProductService{

    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1,"Iphone","Smartphone", "US"));
        productMap.put(2, new Product(2,"Xiaomi","Smartphone", "China"));
        productMap.put(3, new Product(3,"Bphone","Smartphone", "Viet Nam"));
        productMap.put(4, new Product(4,"Samsung","Smartphone", "Korea"));
        productMap.put(5, new Product(5,"Roll-Royce","Xe của chủ tịch", "England"));
        productMap.put(6, new Product(6,"Lamborghini","Xe để đua", "Italy"));
        productMap.put(7, new Product(7,"Porsche","Xe để đua", "Italy"));
        productMap.put(8, new Product(8,"Aston Martin","Xe thể thao", "England"));
        productMap.put(9, new Product(9,"Bentley","Xe của chủ tịch", "England"));
        productMap.put(10, new Product(10,"Jaguar","Xe của con chủ tịch", "England"));
        productMap.put(11, new Product(11,"Land Rover","Xe của cháu chủ tịch", "England"));
        productMap.put(12, new Product(2,"McLaren Senna","Xe thể thao", "England"));
        productMap.put(13, new Product(13,"Mercedes-Benz","Xe của con chủ tịch", "Germany"));
        productMap.put(14, new Product(14,"Ferrari","Xe thể thao", "Italy"));
        productMap.put(15, new Product(15,"Ford Motor","Xe hơi", "US"));
        productMap.put(16, new Product(16,"BMW","Xe của con chủ tịch", "Germany"));
        productMap.put(17, new Product(17,"Toyota","Xe tầm trung", "Japan"));
        productMap.put(18, new Product(18,"Lexus","Xe của bố chủ tịch", "Japan"));
        productMap.put(19, new Product(19,"Audi","Xe của con chủ tịch", "Germany"));
        productMap.put(20, new Product(20,"Hyundai","Xe tầm trung", "Korea"));
        productMap.put(21, new Product(21,"Vinfast","Xe của Việt Nam", "Viet Nam"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id) ;
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> products = this.findAll();
        List<Product> productList = new ArrayList<>();
        String productName;
        name = name.toLowerCase();
        for (Product product : products) {
            productName = product.getName().toLowerCase();
            if (productName.contains(name)) {
                productList.add(product);
            }
        }
        return productList;
    }
}
