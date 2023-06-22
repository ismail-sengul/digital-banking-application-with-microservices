package com.digitalbankingapplication.transactionservice.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class TransactionInternalRequestDto {

    @NotNull
    @Positive
    private Long accountId;

    @NotNull
    @Positive
    private BigDecimal amount;
}
