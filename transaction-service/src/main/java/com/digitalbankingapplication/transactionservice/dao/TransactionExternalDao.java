package com.digitalbankingapplication.transactionservice.dao;

import com.digitalbankingapplication.transactionservice.entity.TransactionExternal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionExternalDao extends JpaRepository<TransactionExternal,Long> {
}
