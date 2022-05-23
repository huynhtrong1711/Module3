package com.codegym.repository.customer.impl;

import com.codegym.model.Customer;
import com.codegym.repository.customer.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement( "SELECT * FROM customer \n" +
                            "join customer_type on customer.customer_type_id = customer_type.customer_type_id");
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setIdCustomer(resultSet.getInt("customer_id"));
                customer.setCustomerCode(resultSet.getString("customer_code"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(resultSet.getString("customer_birthday"));
                customer.setCustomerGender(resultSet.getBoolean("customer_gender"));
                customer.setCustomerCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
                customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customer.setCustomerTypeName(resultSet.getString("customer_type_name"));
                list.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void saveCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("INSERT INTO casestudy_module3.customer (customer_code, customer_type_id,customer_name, customer_birthday, customer_gender,customer_id_card, customer_phone, customer_email, customer_address) " +
                            "VALUES ( ?, ?, ?,?,?,?,?,?,?)");
            preparedStatement.setString(1, customer.getCustomerCode());
            preparedStatement.setString(3, customer.getCustomerName());
            preparedStatement.setString(4, customer.getCustomerBirthday());
            preparedStatement.setBoolean(5, customer.getCustomerGender());
            preparedStatement.setString(6, customer.getCustomerCard());
            preparedStatement.setString(8, customer.getCustomerEmail());
            preparedStatement.setString(7, customer.getCustomerPhone());
            preparedStatement.setString(9, customer.getCustomerAddress());
            preparedStatement.setInt(2, customer.getCustomerTypeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from customer join customer_type on customer.customer_type_id = customer_type.customer_type_id where customer_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer();
                customer.setIdCustomer(id);
                customer.setCustomerCode(resultSet.getString("customer_code"));
                customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(resultSet.getString("customer_birthday"));
                customer.setCustomerGender(resultSet.getBoolean("customer_gender"));
                customer.setCustomerCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
                customer.setCustomerTypeName(resultSet.getString("customer_type_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("update customer set customer_code = ?, customer_type_id = ?,customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ? where customer_id = ?");
            preparedStatement.setString(1, customer.getCustomerCode());
            preparedStatement.setInt(2, customer.getCustomerTypeId());
            preparedStatement.setString(3, customer.getCustomerName());
            preparedStatement.setString(4, customer.getCustomerBirthday());
            preparedStatement.setBoolean(5, customer.getCustomerGender());
            preparedStatement.setString(6, customer.getCustomerCard());
            preparedStatement.setString(7, customer.getCustomerPhone());
            preparedStatement.setString(8, customer.getCustomerEmail());
            preparedStatement.setString(9, customer.getCustomerAddress());
            preparedStatement.setInt(10,customer.getIdCustomer());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {
        Connection connection = new BaseRepository().getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement("delete from customer where customer_id = ?");
                preparedStatement.setInt(1,id);
                preparedStatement.executeUpdate();
            }catch (SQLException e){
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
    public List<Customer> searchByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().
                    prepareStatement("select * from customer join customer_type on customer.customer_type_id = customer_type.customer_type_id where customer_name like ?");
            preparedStatement.setString(1, "%"+ name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setIdCustomer(resultSet.getInt("customer_id"));
                customer.setCustomerCode(resultSet.getString("customer_code"));
                customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
                customer.setCustomerName(resultSet.getString("customer_name"));
                customer.setCustomerBirthday(resultSet.getString("customer_birthday"));
                customer.setCustomerGender(resultSet.getBoolean("customer_gender"));
                customer.setCustomerCard(resultSet.getString("customer_id_card"));
                customer.setCustomerPhone(resultSet.getString("customer_phone"));
                customer.setCustomerEmail(resultSet.getString("customer_email"));
                customer.setCustomerAddress(resultSet.getString("customer_address"));
                customer.setCustomerTypeName(resultSet.getString("customer_type_name"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
