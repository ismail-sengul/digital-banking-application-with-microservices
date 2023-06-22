package com.digitalbankingapplication.transactionservice.controller;

import com.digitalbankingapplication.transactionservice.dto.TransactionExternalDto;
import com.digitalbankingapplication.transactionservice.dto.TransactionExternalRequestDto;
import com.digitalbankingapplication.transactionservice.dto.TransactionInternalDto;
import com.digitalbankingapplication.transactionservice.dto.TransactionInternalRequestDto;
import com.digitalbankingapplication.transactionservice.generic.response.RestResponse;
import com.digitalbankingapplication.transactionservice.service.TransactionExternalService;
import com.digitalbankingapplication.transactionservice.service.TransactionInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionExternalService transactionExternalService;
    private final TransactionInternalService transactionInternalService;
    @PutMapping("/money-transfer")
    public ResponseEntity transferMoney(@RequestBody TransactionExternalRequestDto moneyTransferRequestDto){
        TransactionExternalDto moneyTransferDto = transactionExternalService.transferMoney(moneyTransferRequestDto);

        return ResponseEntity.ok(RestResponse.of(moneyTransferDto));
    }

    @PutMapping("/withdraw")
    public ResponseEntity withdraw(@RequestBody TransactionInternalRequestDto moneyActivityRequestDto){
        TransactionInternalDto moneyActivityDto = transactionInternalService.withdraw(moneyActivityRequestDto);

        return ResponseEntity.ok(RestResponse.of(moneyActivityDto));
    }

    @PutMapping("/deposit")
    public ResponseEntity deposit(@RequestBody TransactionInternalRequestDto moneyActivityRequestDto){
        TransactionInternalDto moneyActivityDto = transactionInternalService.deposit(moneyActivityRequestDto);

        return ResponseEntity.ok(RestResponse.of(moneyActivityDto));
    }
}
