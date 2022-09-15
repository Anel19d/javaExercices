package com.demo.service;

import com.demo.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

     List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Integer id);

    Customer save(Customer customer);

    void deleteCustomer(Integer id);
}
