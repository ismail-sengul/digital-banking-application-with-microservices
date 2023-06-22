package com.digitalbankingapplication.accountservice.entity;


import com.digitalbankingapplication.accountservice.enums.EnumCurrencyType;
import com.digitalbankingapplication.accountservice.enums.EnumStatus;
import com.digitalbankingapplication.accountservice.generic.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "ACCOUNT")
public class Account extends BaseEntity {

    @Id
    @SequenceGenerator(name = "Account", sequenceName = "ACCOUNT_ID_SEQ")
    @GeneratedValue(generator = "Account")
    private Long id;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Size(min = 26, max = 26)
    @Column(name = "IBAN_NO", length = 26)
    private String ibanNo;

    @Column(name = "CURRENT_BALANCE", precision = 19, scale = 2)
    private BigDecimal currentBalance;

    @Enumerated(EnumType.STRING)
    @Column(name = "CURRENCY_TYPE", length = 30)
    private EnumCurrencyType currencyType;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 30)
    private EnumStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CANCEL_DATE")
    private Date cancelDate;
}
