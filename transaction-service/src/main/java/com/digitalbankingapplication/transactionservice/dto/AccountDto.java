package com.digitalbankingapplication.transactionservice.dto;

import com.digitalbankingapplication.transactionservice.enums.EnumAccountType;
import com.digitalbankingapplication.transactionservice.enums.EnumCurrencyType;
import com.digitalbankingapplication.transactionservice.generic.enums.EnumGenStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class AccountDto {

    private Long id;
    private Long customerId;
    private String ibanNo;
    private BigDecimal currentBalance;
    private EnumCurrencyType currencyType;
    private EnumAccountType accountType;
    private EnumGenStatus status;
    private Date cancelDate;

}
