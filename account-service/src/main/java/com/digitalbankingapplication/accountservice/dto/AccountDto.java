package com.digitalbankingapplication.accountservice.dto;

import com.digitalbankingapplication.accountservice.enums.EnumCurrencyType;
import com.digitalbankingapplication.accountservice.enums.EnumStatus;
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
    private EnumStatus status;
    private Date cancelDate;

}
