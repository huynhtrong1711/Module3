package com.codegym.repository.customer.impl;

import com.codegym.model.CustomerType;
import com.codegym.repository.customer.ICustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {

    @Override
    public List<CustomerType> findAll() {
        Connection connection = new BaseRepository().getConnection();
        List<CustomerType> customerList = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("SELECT * FROM customer_type");
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int idCustomerType = resultSet.getInt("customer_type_id");
                    String nameCustomerType = resultSet.getString("customer_type_name");
                    customerList.add(new CustomerType(idCustomerType, nameCustomerType));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return customerList;
    }
}
