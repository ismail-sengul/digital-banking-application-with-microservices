package com.digitalbankingapplication.accountservice.clients;

import com.digitalbankingapplication.accountservice.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service",url = "http://localhost:8762/api/v1/customers")
public interface CustomerClient {

    @GetMapping("/{id}")
    public CustomerDto findById(@PathVariable Long id);
}
