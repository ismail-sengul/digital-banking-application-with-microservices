package com.digitalbankingapplication.accountservice.converter;

import com.digitalbankingapplication.accountservice.dto.AccountDto;
import com.digitalbankingapplication.accountservice.dto.AccountSaveRequestDto;
import com.digitalbankingapplication.accountservice.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto convertToAccountDto(Account account);
    Account convertAccountDtoToAccount(AccountDto accountDto);

    List<AccountDto> convertToAccountDtoList(List<Account> accountList);

    Account convertToAccount(AccountSaveRequestDto accountSaveRequestDto);
}
