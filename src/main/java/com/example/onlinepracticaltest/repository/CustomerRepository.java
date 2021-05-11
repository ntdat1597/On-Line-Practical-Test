package com.example.onlinepracticaltest.repository;

import com.example.onlinepracticaltest.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
