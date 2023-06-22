package com.digitalbankingapplication.customerservice.service.entityservice;

import com.digitalbankingapplication.customerservice.dao.CustomerDao;
import com.digitalbankingapplication.customerservice.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerEntityService {

    private final CustomerDao customerDao;

    public List<Customer> findAll(){
        return customerDao.findAll();
    }

    public Optional<Customer> findById(Long id){
        return customerDao.findById(id);
    }
    public Optional<Customer> findByName(String name) { return customerDao.findCustomerByName(name); }

    public Customer save(Customer customer){
        return customerDao.save(customer);
    }

    public void deleteById(Long id){
        customerDao.deleteById(id);
    }

    public boolean isExist(Long id){
        return customerDao.existsById(id);
    }
}
