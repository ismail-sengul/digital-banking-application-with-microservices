package com.digitalbankingapplication.accountservice.controller;

import com.digitalbankingapplication.accountservice.dto.AccountDto;
import com.digitalbankingapplication.accountservice.dto.AccountSaveRequestDto;
import com.digitalbankingapplication.accountservice.response.RestResponse;
import com.digitalbankingapplication.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<AccountDto> findAll(){
        List<AccountDto> accountDtoList = accountService.findAll();

        return accountDtoList;
    }

    @GetMapping("/{id}")
    public AccountDto findById(@PathVariable Long id){

        AccountDto accountDto = accountService.findById(id);

        return accountDto;
    }

    @PostMapping
    public AccountDto save(@RequestBody AccountSaveRequestDto accountSaveRequestDto){

        AccountDto accountDto = accountService.save(accountSaveRequestDto);

        return accountDto;
    }
    @PutMapping("/update/{id}")
    public AccountDto update(@PathVariable(value = "id") Long accountId, @RequestBody AccountDto account){

        AccountDto accountDto = accountService.update(account);

        return accountDto;
    }


    @PatchMapping("/cancel/{id}")
    public ResponseEntity cancel(@PathVariable Long id){

        accountService.cancel(id);

        return ResponseEntity.ok(RestResponse.empty());
    }
}
