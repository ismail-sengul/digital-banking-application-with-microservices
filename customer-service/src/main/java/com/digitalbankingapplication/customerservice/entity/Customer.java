package com.digitalbankingapplication.customerservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @SequenceGenerator(name = "CUSTOMER", sequenceName = "CUSTOMER_ID_SEQ")
    @GeneratedValue(generator = "CUSTOMER")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100, nullable = false)
    private String surname;

    @Column(name = "IDENTITY_NO", nullable = false)
    private Long identityNo;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

}
