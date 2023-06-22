package com.digitalbankingapplication.customerservice.service;

import com.digitalbankingapplication.customerservice.converter.CustomerMapper;
import com.digitalbankingapplication.customerservice.dto.CustomerDto;
import com.digitalbankingapplication.customerservice.dto.CustomerSaveRequestDto;
import com.digitalbankingapplication.customerservice.dto.CustomerUpdateRequestDto;
import com.digitalbankingapplication.customerservice.entity.Customer;
import com.digitalbankingapplication.customerservice.service.entityservice.CustomerEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@CrossOrigin
public class CustomerService {

    private final CustomerEntityService customerEntityService;

    private final PasswordEncoder passwordEncoder;

    public List<CustomerDto> findAll(){

        List<Customer> customerList = customerEntityService.findAll();

        List<CustomerDto> customerDtoList = CustomerMapper.INSTANCE.convertToCustomerDtoList(customerList);

        return customerDtoList;
    }

    public CustomerDto findById(Long id){
        Optional<Customer> optionalCustomer = customerEntityService.findById(id);

        if (!optionalCustomer.isPresent()){
            return null;
        }

        Customer customer = optionalCustomer.get();

        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);

        return customerDto;
    }

    public CustomerDto findByIdWithControl(Long id){

        Customer customer = customerEntityService.findById(id).orElseThrow();

        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);

        return customerDto;
    }

    public CustomerDto save(CustomerSaveRequestDto customerSaveRequestDto){

        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(customerSaveRequestDto);

        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);

        customer = customerEntityService.save(customer);

        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);

        return customerDto;
    }

    public void deleteById(Long id) {

        customerEntityService.deleteById(id);
    }

    public CustomerDto update(CustomerUpdateRequestDto customerUpdateRequestDto) {

        boolean isExist = customerEntityService.isExist(customerUpdateRequestDto.getId());
        if (!isExist){
            throw new RuntimeException("CUSTOMER DOES NOT EXIST!");
        }

        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(customerUpdateRequestDto);

        String encodedPassword = passwordEncoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);

        customer = customerEntityService.save(customer);

        CustomerDto customerDto = CustomerMapper.INSTANCE.convertToCustomerDto(customer);

        return customerDto;
    }

}
