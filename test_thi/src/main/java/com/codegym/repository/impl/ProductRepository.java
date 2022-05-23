package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.omg.CORBA.TRANSACTION_MODE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =this.baseRepository.getConnection().
                    prepareStatement("select * from product join categogy on product.id_categogy  = categogy.id_categogy");
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product;
            while (resultSet.next()) {
            product = new Product();
            product.setId(resultSet.getInt("id"));
            product.setNameProduct(resultSet.getString("name_product"));
            product.setPrice(resultSet.getDouble("price"));
            product.setAmount(resultSet.getInt("amount"));
            product.setColor(resultSet.getString("color"));
            product.setDescription(resultSet.getString("description"));
            product.setIdCategory(resultSet.getInt("id_categogy"));
            product.setNameCategory(resultSet.getString("name_categogy"));
            productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void saveProduct(Product product) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("insert into product (name_product,price,amount,color,description,id_categogy) values (?,?,?,?,?,?)");
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getIdCategory());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateProduct(Product product) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("update product set name_product = ?, price = ?, amount = ?, color = ?, description = ? , id_categogy = ? where id = ?");
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getIdCategory());
            preparedStatement.setInt(7, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from product join categogy on product.id_categogy = categogy.id_categogy where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                product = new Product();
                product.setId(id);
                product.setNameProduct(resultSet.getString("name_product"));
                product.setPrice(resultSet.getDouble("price"));
                product.setAmount(resultSet.getInt("amount"));
                product.setColor(resultSet.getString("color"));
                product.setDescription(resultSet.getString("description"));
                product.setIdCategory(resultSet.getInt("id_categogy"));
                product.setNameCategory(resultSet.getString("name_categogy"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public void delete(int id) {
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("delete from product where id =? ");
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from product join categogy on product.id_categogy = categogy.id_categogy where name_product like ?");
            preparedStatement.setString(1,"%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Product product;
            while (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setNameProduct(resultSet.getString("name_product"));
                product.setPrice(resultSet.getDouble("price"));
                product.setAmount(resultSet.getInt("amount"));
                product.setColor(resultSet.getString("color"));
                product.setDescription(resultSet.getString("description"));
                product.setIdCategory(resultSet.getInt("id_categogy"));
                product.setNameCategory(resultSet.getString("name_categogy"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
}
