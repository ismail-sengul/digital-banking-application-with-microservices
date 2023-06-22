package com.digitalbankingapplication.accountservice.service;

import com.digitalbankingapplication.accountservice.clients.CustomerClient;
import com.digitalbankingapplication.accountservice.converter.AccountMapper;
import com.digitalbankingapplication.accountservice.converter.AccountMapperImpl;
import com.digitalbankingapplication.accountservice.dto.AccountDto;
import com.digitalbankingapplication.accountservice.dto.AccountSaveRequestDto;
import com.digitalbankingapplication.accountservice.entity.Account;
import com.digitalbankingapplication.accountservice.enums.EnumStatus;
import com.digitalbankingapplication.accountservice.enums.ErrorMessage;
import com.digitalbankingapplication.accountservice.dto.CustomerDto;
import com.digitalbankingapplication.accountservice.generic.exceptions.BusinessException;
import com.digitalbankingapplication.accountservice.service.entityservice.AccountEntityService;
import com.digitalbankingapplication.accountservice.util.AccountUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@CrossOrigin
public class AccountService {

    private final CustomerClient customerClient;

    private final AccountEntityService accountEntityService;

    public List<AccountDto> findAll(){

        List<Account> accountList = accountEntityService.findAll();

        List<AccountDto> accountDtoList = AccountMapper.INSTANCE.convertToAccountDtoList(accountList);

        return accountDtoList;
    }

    public AccountDto findById(Long id){

        Optional<Account> account = accountEntityService.findById(id);

        if(account == null){
            throw new BusinessException(ErrorMessage.ACCOUNT_COULD_NOT_FIND);
        }

        AccountDto accountDto = AccountMapper.INSTANCE.convertToAccountDto(account.get());

        return accountDto;
    }

    public AccountDto save(AccountSaveRequestDto accountSaveRequestDto){

        CustomerDto customerDto = customerClient.findById(accountSaveRequestDto.getCustomerId());

        if (customerDto == null){
            throw new BusinessException(ErrorMessage.ACCOUNT_COULD_NOT_FIND);
        }

        String ibanNo = AccountUtil.getIbanNo();

        Account account = AccountMapper.INSTANCE.convertToAccount(accountSaveRequestDto);
        account.setIbanNo(ibanNo);
        account.setStatus(EnumStatus.ACTIVE);
        account.setCurrentBalance(BigDecimal.ZERO);
        account.setCurrencyType(accountSaveRequestDto.getCurrencyType());
        account.setCustomerId(accountSaveRequestDto.getCustomerId());
        account = accountEntityService.save(account);

        AccountDto accountDto = AccountMapper.INSTANCE.convertToAccountDto(account);

        return accountDto;
    }

    public AccountDto update(AccountDto accountDto){

        Account account = AccountMapper.INSTANCE.convertAccountDtoToAccount(accountDto);
        System.out.println(account.toString());

        accountEntityService.save(account);

        return accountDto;

    }

    public void cancel(Long id) {

        Account account = accountEntityService.findByIdWithControl(id);

        if(account == null){
            throw new BusinessException(ErrorMessage.ACCOUNT_COULD_NOT_FIND);
        }

        account.setStatus(EnumStatus.PASSIVE);
        account.setCancelDate(new Date());
        accountEntityService.save(account);
    }

}
