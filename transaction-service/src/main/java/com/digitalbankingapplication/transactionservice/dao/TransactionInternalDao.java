package com.digitalbankingapplication.transactionservice.dao;

import com.digitalbankingapplication.transactionservice.entity.TransactionInternal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionInternalDao extends JpaRepository<TransactionInternal,Long> {
}
