package com.bank.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor


@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	private BigDecimal amount;
	private String type; //"Withraw" or "Deposite
	private LocalDateTime transactionDate;
	
	public Transaction(Account account, BigDecimal amount, String type, LocalDateTime transactionDate) {
		super();
		
		this.account = account;
		this.amount = amount;
		this.type = type;
		this.transactionDate = transactionDate;
	}
	
	
	
	
}
