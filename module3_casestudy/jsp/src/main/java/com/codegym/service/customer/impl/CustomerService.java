package com.codegym.service.customer.impl;

import com.codegym.model.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.repository.customer.impl.CustomerRepository;
import com.codegym.service.customer.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.getAllCustomer();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return customerRepository.searchByName(name);
    }
}
