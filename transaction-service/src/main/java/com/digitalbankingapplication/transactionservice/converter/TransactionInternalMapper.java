package com.digitalbankingapplication.transactionservice.converter;

import com.digitalbankingapplication.transactionservice.dto.TransactionInternalDto;
import com.digitalbankingapplication.transactionservice.dto.TransactionInternalRequestDto;
import com.digitalbankingapplication.transactionservice.entity.TransactionInternal;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionInternalMapper {
    TransactionInternalMapper INSTANCE = Mappers.getMapper(TransactionInternalMapper.class);
    TransactionInternal convertToTransactionInternal(TransactionInternalRequestDto transactionInternalRequestDto);

    TransactionInternalDto convertToTransactionInternalDto(TransactionInternal transactionInternal);
}
