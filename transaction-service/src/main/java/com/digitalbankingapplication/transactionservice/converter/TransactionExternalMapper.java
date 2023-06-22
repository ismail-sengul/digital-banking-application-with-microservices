package com.digitalbankingapplication.transactionservice.converter;

import com.digitalbankingapplication.transactionservice.dto.TransactionExternalDto;
import com.digitalbankingapplication.transactionservice.dto.TransactionExternalRequestDto;
import com.digitalbankingapplication.transactionservice.entity.TransactionExternal;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionExternalMapper {

    TransactionExternalMapper INSTANCE = Mappers.getMapper(TransactionExternalMapper.class);
    TransactionExternal convertToTransactionExternal(TransactionExternalRequestDto moneyTransferRequestDto);

    TransactionExternalDto convertToTransactionExternalDto(TransactionExternal moneyTransfer);
}
