package com.bank.DTO;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AccountDTO {

	//private long id;
	private String cname;
	
	//@Column(name = "accountnumber")
	private String accountNumber;
	//private BigDecimal amount;
}
