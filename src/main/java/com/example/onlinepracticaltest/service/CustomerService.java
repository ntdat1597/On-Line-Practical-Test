package com.example.onlinepracticaltest.service;

import com.example.onlinepracticaltest.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    boolean saveCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(int cust_id);
    Customer getCustById(int cust_id);
}
