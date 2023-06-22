package com.digitalbankingapplication.transactionservice.service;

import com.digitalbankingapplication.transactionservice.clients.AccountClient;
import com.digitalbankingapplication.transactionservice.converter.TransactionInternalMapper;
import com.digitalbankingapplication.transactionservice.dto.AccountDto;
import com.digitalbankingapplication.transactionservice.dto.TransactionInternalDto;
import com.digitalbankingapplication.transactionservice.dto.TransactionInternalRequestDto;
import com.digitalbankingapplication.transactionservice.entity.TransactionInternal;
import com.digitalbankingapplication.transactionservice.enums.EnumActivityType;
import com.digitalbankingapplication.transactionservice.service.entityservice.TransactionInternalEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.util.Date;

@Service
@RequiredArgsConstructor
@CrossOrigin
public class TransactionInternalService {

    private final AccountClient accountClient;
    private final TransactionInternalEntityService transactionInternalEntityService;
    public TransactionInternalDto withdraw(TransactionInternalRequestDto transactionInternalRequestDto){

        AccountDto account = accountClient.findById(transactionInternalRequestDto.getAccountId());

        TransactionInternalDto transactionInternalDtoTo = TransactionInternalDto.builder()
                .accountId(account.getId())
                .amount(transactionInternalRequestDto.getAmount())
                .activityType(EnumActivityType.WITHDRAW)
                .build();

        TransactionInternal accountActivity = moneyOut(transactionInternalDtoTo);

        TransactionInternalDto transactionInternalDto = TransactionInternalMapper.INSTANCE.convertToTransactionInternalDto(accountActivity);

        return transactionInternalDto;

    }

    public TransactionInternalDto deposit(TransactionInternalRequestDto transactionInternalRequestDto){
        AccountDto account = accountClient.findById(transactionInternalRequestDto.getAccountId());
        System.out.println(transactionInternalRequestDto.toString());
        System.out.println(account.toString());
        TransactionInternalDto transactionInternalDtoTo = TransactionInternalDto.builder()
                .accountId(account.getId())
                .amount(transactionInternalRequestDto.getAmount())
                .activityType(EnumActivityType.DEPOSIT)
                .build();

        TransactionInternal accountActivity = moneyIn(transactionInternalDtoTo);

        TransactionInternalDto transactionInternalDto = TransactionInternalMapper.INSTANCE.convertToTransactionInternalDto(accountActivity);

        return transactionInternalDto;

    }

    public TransactionInternal moneyIn(TransactionInternalDto transactionInternalDto){
        AccountDto account = accountClient.findById(transactionInternalDto.getAccountId());

        BigDecimal newBalance = calculateNewBalanceForMoneyIn(transactionInternalDto.getAmount(), account.getCurrentBalance());

        updateCurrentBalance(account, newBalance);

        TransactionInternal transactionInternal = createAccountActivity(transactionInternalDto.getAccountId(), transactionInternalDto.getAmount(), newBalance, transactionInternalDto.getActivityType());

        return transactionInternal;
    }

    public TransactionInternal moneyOut(TransactionInternalDto transactionInternalDto){

        AccountDto account = accountClient.findById(transactionInternalDto.getAccountId());

        BigDecimal newBalance = calculateAndControlNewBalanceForMoneyOut(transactionInternalDto.getAmount(), account.getCurrentBalance());

        TransactionInternal transactionInternal = createAccountActivity(account.getId(), transactionInternalDto.getAmount(), newBalance, transactionInternalDto.getActivityType());

        updateCurrentBalance(account, newBalance);

        return transactionInternal;
    }

    private void updateCurrentBalance(AccountDto accountFrom, BigDecimal newBalance) {
        accountFrom.setCurrentBalance(newBalance);
        accountFrom = accountClient.update(accountFrom.getId(),accountFrom);
    }

    private TransactionInternal createAccountActivity(Long accountId, BigDecimal amount, BigDecimal newBalance, EnumActivityType activityType){
        TransactionInternal transactionInternal = new TransactionInternal();

        transactionInternal.setActivityType(activityType);
        transactionInternal.setAmount(amount);
        transactionInternal.setAccountId(accountId);
        transactionInternal.setCurrentBalance(newBalance);
        transactionInternal.setTransactionDate(new Date());

        transactionInternal = transactionInternalEntityService.save(transactionInternal);

        return transactionInternal;
    }

    private BigDecimal calculateAndControlNewBalanceForMoneyOut(BigDecimal amount, BigDecimal currentBalance){
        BigDecimal newBalance = calculateNewBalanceForMoneyOut(amount, currentBalance);
        validateBalance(newBalance);
        return newBalance;
    }

    private void validateBalance(BigDecimal newBalance) {
        if (newBalance.compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Insufficent Balance!");
        }
    }

    private BigDecimal calculateNewBalanceForMoneyOut(BigDecimal amount, BigDecimal currentBalance){
        BigDecimal newBalance = currentBalance.subtract(amount);
        return newBalance;
    }

    private BigDecimal calculateNewBalanceForMoneyIn(BigDecimal amount, BigDecimal currentBalance){
        BigDecimal newBalance = currentBalance.add(amount);
        return newBalance;
    }
}
