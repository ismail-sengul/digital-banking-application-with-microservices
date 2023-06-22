package com.digitalbankingapplication.transactionservice.dto;

import com.digitalbankingapplication.transactionservice.enums.EnumMoneyTransferType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionExternalDto {

    private Long id;
    private Long accountIdFrom;
    private Long accountIdTo;
    private BigDecimal amount;
    private Date transactionDate;
    private String description;
    private EnumMoneyTransferType moneyTransferType;

}
