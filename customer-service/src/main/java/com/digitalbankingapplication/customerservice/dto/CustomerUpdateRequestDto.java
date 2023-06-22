package com.digitalbankingapplication.customerservice.dto;

import lombok.Data;

@Data
public class CustomerUpdateRequestDto {

    private Long id;
    private String name;
    private String surname;
    private Long identityNo;
    private String password;

}
