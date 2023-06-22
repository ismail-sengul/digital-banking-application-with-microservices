package com.digitalbankingapplication.transactionservice.entity;

import com.digitalbankingapplication.transactionservice.enums.EnumActivityType;
import com.digitalbankingapplication.transactionservice.generic.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "TRANSACTION_INTERNAL")
public class TransactionInternal extends BaseEntity {
    @Id
    @SequenceGenerator(name = "AccAccountActivity", sequenceName = "ACC_ACCOUNT_ACTIVITY_ID_SEQ")
    @GeneratedValue(generator = "AccAccountActivity")
    private Long id;

    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    @Column(name = "AMOUNT", precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(name = "CURRENT_BALANCE", precision = 19, scale = 2)
    private BigDecimal currentBalance;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRANSACTION_DATE")
    private Date transactionDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "ACTIVITY_TYPE", length = 30)
    private EnumActivityType activityType;
}
