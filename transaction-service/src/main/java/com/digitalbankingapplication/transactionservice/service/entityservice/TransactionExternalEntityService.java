package com.digitalbankingapplication.transactionservice.service.entityservice;

import com.digitalbankingapplication.transactionservice.dao.TransactionExternalDao;
import com.digitalbankingapplication.transactionservice.entity.TransactionExternal;
import com.digitalbankingapplication.transactionservice.generic.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class TransactionExternalEntityService extends BaseEntityService<TransactionExternal, TransactionExternalDao> {
    public TransactionExternalEntityService(TransactionExternalDao dao) {
        super(dao);
    }
}
