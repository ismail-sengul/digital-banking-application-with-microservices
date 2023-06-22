package com.digitalbankingapplication.customerservice.converter;

import com.digitalbankingapplication.customerservice.dto.CustomerDto;
import com.digitalbankingapplication.customerservice.dto.CustomerSaveRequestDto;
import com.digitalbankingapplication.customerservice.dto.CustomerUpdateRequestDto;
import com.digitalbankingapplication.customerservice.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto convertToCustomerDto(Customer customer);

    List<CustomerDto> convertToCustomerDtoList(List<Customer> customerList);

    Customer convertToCustomer(CustomerSaveRequestDto customerSaveRequestDto);

    Customer convertToCustomer(CustomerUpdateRequestDto customerUpdateRequestDto);

}
