package com.digitalbankingapplication.transactionservice.service.entityservice;

import com.digitalbankingapplication.transactionservice.dao.TransactionInternalDao;
import com.digitalbankingapplication.transactionservice.entity.TransactionInternal;
import com.digitalbankingapplication.transactionservice.generic.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class TransactionInternalEntityService extends BaseEntityService<TransactionInternal, TransactionInternalDao> {
    public TransactionInternalEntityService(TransactionInternalDao dao) {
        super(dao);
    }
}
