package com.bank.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cname;
	private String password;
	
	@Column(name = "accountnumber")
	private String accountNumber;
	private BigDecimal balance;
	
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	List<Transaction> transactions = new ArrayList<>();
	
//	private double deposite;
//	private double total;
	
	
}
