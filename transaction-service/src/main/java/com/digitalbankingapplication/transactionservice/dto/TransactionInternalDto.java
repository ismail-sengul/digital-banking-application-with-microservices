package com.digitalbankingapplication.transactionservice.dto;

import com.digitalbankingapplication.transactionservice.enums.EnumActivityType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionInternalDto {

    private Long accountId;
    private BigDecimal amount;
    private EnumActivityType activityType;
}
