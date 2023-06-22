package com.digitalbankingapplication.accountservice.dao;

import com.digitalbankingapplication.accountservice.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {

}

