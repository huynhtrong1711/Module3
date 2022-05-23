package com.codegym.repository.customer;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getAllCustomer();
    void saveCustomer(Customer customer);
     void updateCustomer(Customer customer);
     Customer findById(int id);
    void delete(int id);
    List<Customer> searchByName(String name);
}
