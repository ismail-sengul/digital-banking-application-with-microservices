package com.digitalbankingapplication.transactionservice.clients;

import com.digitalbankingapplication.transactionservice.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "account-service", url = "http://localhost:8763/api/v1/accounts")
public interface AccountClient {
    @GetMapping("/{id}")
    public AccountDto findById(@PathVariable Long id);

    @PutMapping("/update/{id}")
    public AccountDto update(@PathVariable(value = "id") Long accountId, @RequestBody AccountDto account);
}
