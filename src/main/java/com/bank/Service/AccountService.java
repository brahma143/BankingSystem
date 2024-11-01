package com.bank.Service;

import java.math.BigDecimal;
import java.util.List;

import com.bank.DTO.AccountDTO;
import com.bank.Entity.Account;
import com.bank.Entity.Transaction;

public interface AccountService {

	//save new customers data
	public Account saveCustomers(Account account);
	
	//get list of all customers
	public List<Account> getAll();
	
	//get id
	public Account getAccountById(long aid);
	
	//update
	public Account updateAccount(Account account, long aid);
	
		
	//delete
	public void deleteAccount(long aid);
	
	//public Account deposit(Account account);

	Account deposit(String accountNumber, BigDecimal amount);
	 public List<AccountDTO> getAccountNumberAndCname();
	

	public Account witdraw(String accountNumber, BigDecimal amount);
	
	//find By username
	public void findUsername(Account account);
	
	public void transFunds(String fromAccount,String toAccount,BigDecimal amount);
	
	public Account findByAccountNumberAndBalance(String AccountNumber, BigDecimal balance);

	//transactions
	public List<Transaction> gettransactions();
	
   
}