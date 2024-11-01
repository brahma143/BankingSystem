package com.bank.ServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.DTO.AccountDTO;
import com.bank.Entity.Account;
import com.bank.Entity.Transaction;
import com.bank.Repository.AccountRepo;
import com.bank.Repository.TransactionRepo;
import com.bank.Service.AccountService;

@Service
public class AccountImpl implements AccountService{

	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	TransactionRepo transactionRepo;
	
	@Override
	public Account saveCustomers(Account account) {
		// TODO Auto-generated method stub
		Account acc= accountRepo.save(account);
		return acc;
	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		List<Account> list= accountRepo.findAll();
		return list;
	}

	@Override
	public Account getAccountById(long aid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account updateAccount(Account account, long aid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(long aid) {
		// TODO Auto-generated method stub
		
		accountRepo.deleteById(aid);
	}
	
	public void findUsername(Account account) {
	
		 Account account1;
		 // Retrieve the account based on the username (Cname)
		   Account existingAccount=accountRepo.findByCname(account.getCname());
		if(existingAccount != null && existingAccount.getCname().equals(account.getCname())) {
			
			System.out.println("user and password valid");
		}else {
			System.out.println("user Details Invalid, check once again? !!");
		}
	}

	@Override
	public Account deposit(String accountNumber,BigDecimal amount) {
		// TODO Auto-generated method stub
		
		
		 // Check if account number is not null
	    if (accountNumber == null) {
	        throw new IllegalArgumentException("Account number cannot be null.");
	    }
	    System.out.println("Account Number: " + accountNumber);

	 // Fetch the account using account number
	    Optional<Account> accountOptional = accountRepo.findByAccountNumber(accountNumber);

	    if (accountOptional.isEmpty()) {
	        throw new IllegalArgumentException("Account not found for account number: " + accountNumber);
	    }
		
		Account account = accountOptional.get();

		 // Update account balance
	    account.setBalance(account.getBalance().add(amount));
	    accountRepo.save(account);
		
			//Log to the transaction
	    // Log the transaction with the transaction type "Deposit"
      Transaction transaction = new Transaction( account,amount,"Deposite",LocalDateTime.now());
      transactionRepo.save(transaction);
       
      return account;
	}
	
//	public Account witdraw(String accountNumber, BigDecimal amount) {
//		
//		Optional<Account> account = accountRepo.findByAccountNumber(accountNumber);
//		
//		if(account.getBalance().compareTo(amount)<0) {
//			throw new RuntimeException("Insufficient Balance");
//		}
//		
//		account.setBalance(account.getBalance().subtract(amount));
//		accountRepo.save(account);
//		
//		Transaction transaction = new Transaction(account,amount,"Withdraw",LocalDateTime.now());
//		transactionRepo.save(transaction);
//		
//		return account;
//	}
	
	public List<Transaction> gettransactions() {
		
		 List<Transaction>  transaction = transactionRepo.findAll();
		 
		 return transaction;
	}
    
	public void transFunds(String fromAccount,String toAccount,BigDecimal amount) {
		
		witdraw(fromAccount, amount);
			deposit(toAccount, amount);
		
	}

//	
	 public List<AccountDTO> getAccountNumberAndCname() {
	        return accountRepo.findAccountNumberAndCname();
	    }
	// findAccountNumberAndCname

	@Override
	public Account findByAccountNumberAndBalance(String AccountNumber, BigDecimal balance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account witdraw(String accountNumber, BigDecimal amount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
