package com.digitalbankingapplication.customerservice.dao;

import com.digitalbankingapplication.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer, Long> {
    public Optional<Customer> findCustomerByName(String name);
}
