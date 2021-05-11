package com.example.onlinepracticaltest.service.impl;


import com.example.onlinepracticaltest.model.Customer;
import com.example.onlinepracticaltest.repository.CustomerRepository;
import com.example.onlinepracticaltest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getAllCustomer() {
        try{
            List<Customer> list = customerRepository.findAll();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        try{
            customer.setCreated(new Date());
            customerRepository.save(customer);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        try{
            customerRepository.save(customer);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int cust_id) {
        try{
            customerRepository.deleteById(cust_id);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer getCustById(int cust_id) {
        try{
            Customer customer = customerRepository.findById(cust_id).get();
            return customer;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }