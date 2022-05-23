package com.codegym.repository.customer;

import com.codegym.model.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository {
    List<CustomerType> findAll();
}
