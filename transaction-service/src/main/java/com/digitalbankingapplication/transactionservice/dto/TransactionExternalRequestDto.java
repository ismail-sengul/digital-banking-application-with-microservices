package com.digitalbankingapplication.transactionservice.dto;

import com.digitalbankingapplication.transactionservice.enums.EnumMoneyTransferType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class TransactionExternalRequestDto {

    @NotNull
    @Positive
    private Long accountIdFrom;

    @NotNull
    @Positive
    private Long accountIdTo;

    @NotNull
    @Positive
    private BigDecimal amount;
    private String description;
    private EnumMoneyTransferType moneyTransferType;

}
