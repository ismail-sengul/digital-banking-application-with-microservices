package com.digitalbankingapplication.accountservice.dto;

import com.digitalbankingapplication.accountservice.enums.EnumCurrencyType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class AccountSaveRequestDto {

    @NotNull
    @Positive
    private Long customerId;

    private EnumCurrencyType currencyType;

}
