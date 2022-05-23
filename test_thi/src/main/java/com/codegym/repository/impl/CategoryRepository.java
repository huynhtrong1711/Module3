package com.codegym.repository.impl;

import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        Connection connection = new BaseRepository().getConnection();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("select * from categogy");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id =resultSet.getInt("id_categogy");
                    String nameCategory = resultSet.getString("name_categogy");
                    categoryList.add(new Category(id,nameCategory));
                }
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
        return categoryList;
    }
}
