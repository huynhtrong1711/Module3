package com.codegym.service.customer.impl;

import com.codegym.model.CustomerType;
import com.codegym.repository.customer.ICustomerTypeRepository;
import com.codegym.repository.customer.impl.CustomerTypeRepository;
import com.codegym.service.customer.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    private ICustomerTypeRepository iCustomerTypeRepository = new CustomerTypeRepository();
    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }
}
