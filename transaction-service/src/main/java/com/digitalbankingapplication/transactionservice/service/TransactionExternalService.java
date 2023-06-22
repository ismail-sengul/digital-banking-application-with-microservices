package com.digitalbankingapplication.transactionservice.service;

import com.digitalbankingapplication.transactionservice.clients.AccountClient;
import com.digitalbankingapplication.transactionservice.converter.TransactionExternalMapper;
import com.digitalbankingapplication.transactionservice.dto.AccountDto;
import com.digitalbankingapplication.transactionservice.dto.TransactionExternalDto;
import com.digitalbankingapplication.transactionservice.dto.TransactionExternalRequestDto;
import com.digitalbankingapplication.transactionservice.dto.TransactionInternalDto;
import com.digitalbankingapplication.transactionservice.entity.TransactionExternal;
import com.digitalbankingapplication.transactionservice.enums.EnumActivityType;
import com.digitalbankingapplication.transactionservice.service.entityservice.TransactionExternalEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

@Service
@RequiredArgsConstructor
@CrossOrigin
public class TransactionExternalService {

    private final AccountClient accountClient;
    private final TransactionInternalService transactionInternalService;
    private final TransactionExternalEntityService transactionExternalEntityService;
    public TransactionExternalDto transferMoney(TransactionExternalRequestDto transactionExternalRequestDto){

        TransactionExternal transactionExternal = TransactionExternalMapper.INSTANCE.convertToTransactionExternal(transactionExternalRequestDto);
        transactionExternal.setTransactionDate(new Date());

        AccountDto accountFrom = accountClient.findById(transactionExternalRequestDto.getAccountIdFrom());
        AccountDto accountTo = accountClient.findById(transactionExternalRequestDto.getAccountIdTo());


        TransactionInternalDto transactionInternalDtoFrom = TransactionInternalDto.builder()
                .accountId(accountFrom.getId())
                .amount(transactionExternalRequestDto.getAmount())
                .activityType(EnumActivityType.SEND)
                .build();

        TransactionInternalDto transactionInternalDtoTo = TransactionInternalDto.builder()
                .accountId(accountTo.getId())
                .amount(transactionExternalRequestDto.getAmount())
                .activityType(EnumActivityType.GET)
                .build();

        transactionInternalService.moneyOut(transactionInternalDtoFrom);
        transactionInternalService.moneyIn(transactionInternalDtoTo);

        transactionExternal = transactionExternalEntityService.save(transactionExternal);

        TransactionExternalDto transactionExternalDto = TransactionExternalMapper.INSTANCE.convertToTransactionExternalDto(transactionExternal);

        return transactionExternalDto;
    }
}
