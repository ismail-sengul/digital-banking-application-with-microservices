package com.digitalbankingapplication.customerservice.controller;

import com.digitalbankingapplication.customerservice.dto.CustomerDto;
import com.digitalbankingapplication.customerservice.dto.CustomerSaveRequestDto;
import com.digitalbankingapplication.customerservice.dto.CustomerUpdateRequestDto;
import com.digitalbankingapplication.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> findAll(){
        List<CustomerDto> customerDtoList = customerService.findAll();
        return customerDtoList;
    }

    @GetMapping("/{id}")
    public CustomerDto findById(@PathVariable Long id){
        CustomerDto customerDto = customerService.findById(id);
        return customerDto;
    }


    @PostMapping
    public CustomerDto save(@RequestBody @Valid CustomerSaveRequestDto customerSaveRequestDto){
        CustomerDto customerDto = customerService.save(customerSaveRequestDto);
        return customerDto;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        customerService.deleteById(id);
    }

    @PutMapping
    public CustomerDto update(@RequestBody CustomerUpdateRequestDto customerUpdateRequestDto){
        CustomerDto customerDto = customerService.update(customerUpdateRequestDto);
        return customerDto;
    }

}
