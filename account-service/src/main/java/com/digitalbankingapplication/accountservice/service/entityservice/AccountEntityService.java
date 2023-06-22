package com.digitalbankingapplication.accountservice.service.entityservice;

import com.digitalbankingapplication.accountservice.dao.AccountDao;
import com.digitalbankingapplication.accountservice.entity.Account;
import com.digitalbankingapplication.accountservice.generic.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class AccountEntityService extends BaseEntityService<Account, AccountDao> {

    public AccountEntityService(AccountDao dao){
        super(dao);
    }

}
