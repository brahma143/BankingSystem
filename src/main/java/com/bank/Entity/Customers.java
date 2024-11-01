package com.bank.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cid;
	private String cname;
	private long caccountno;
	private double balance;
	private String cemail;
	private String password;
	
	private String acctype;
	
	
}
