package com.codegym.service.customer;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer findById(int id);
    void delete(int id);
    List<Customer> searchByName(String name);
}
