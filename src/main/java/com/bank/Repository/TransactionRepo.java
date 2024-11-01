package com.bank.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.Entity.Transaction;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long>{

	List<Transaction> findByAccount_Id(Long id);
	
}
