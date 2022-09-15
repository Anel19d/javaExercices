package com.demo.service;

import com.demo.entity.Customer;
import com.demo.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements  CustomerService{

    @Autowired
    CustomerRepo customerRepo;


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepo.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent()) {
            customerRepo.delete(customer.get());
        }
    }


}
