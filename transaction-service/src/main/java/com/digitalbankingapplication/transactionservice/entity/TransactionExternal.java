package com.digitalbankingapplication.transactionservice.entity;

import com.digitalbankingapplication.transactionservice.enums.EnumMoneyTransferType;
import com.digitalbankingapplication.transactionservice.generic.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "TRANSACTION_EXTERNAL")
public class TransactionExternal extends BaseEntity {
    @Id
    @SequenceGenerator(name = "AccMoneyTransfer", sequenceName = "ACC_MONEY_TRANSFER_ID_SEQ")
    @GeneratedValue(generator = "AccMoneyTransfer")
    private Long id;

    @Column(name = "ACCOUNT_ID_FROM")
    private Long accountIdFrom;

    @Column(name = "ACCOUNT_ID_TO")
    private Long accountIdTo;

    @Column(name = "AMOUNT", precision = 19, scale = 2)
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRANSACTION_DATE")
    private Date transactionDate;

    @Column(name = "DESCRIPTION", length = 100)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "MONEY_TRANSFER_TYPE", length = 30)
    private EnumMoneyTransferType moneyTransferType;
}
