package com.bank.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.DTO.AccountDTO;
import com.bank.Entity.Account;
import com.bank.Service.AccountService;

@RestController
@RequestMapping("/")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping("/save")
	public ResponseEntity<Account> saveCust(@RequestBody Account account){
		
		return new ResponseEntity<>(accountService.saveCustomers(account),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Account>> getAll(){
		
		return new ResponseEntity<>(accountService.getAll(),HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteAcc/{aid}")
	public String deleteById(@PathVariable long aid) {
		
		accountService.deleteAccount(aid);
		
		return "Account is successfully Deleted Id is: "+aid;
	}
	
	@PostMapping("/deposites")
	public String deposite(@RequestBody Account account) {
		
		accountService.deposit(account.getAccountNumber(), account.getBalance());
//		@PathVariable String accountnumber,
//		@PathVariable BigDecimal amount
		return "Deposite successfully";
		
	}
	
//	@PostMapping("/withdraw")
//	public String withDraw(@RequestBody AccountDTO accountDTO)
//
//	{
//	   	
//		accountService.witdraw(accountDTO.getAccountNumber(), accountDTO.getAmount());
//		
//		return "Withdraw successfully compledted"+accountDTO;
//	}
	
	@PostMapping("/transfer")
	public String transferFund(@RequestParam String fromAccount,
			@RequestParam String toAccount,@RequestParam BigDecimal amount) {
		
		accountService.transFunds(fromAccount, toAccount,amount);
		
		return "Transaction successfully done fromAccount to toAccount";
		
	}
	
	
}
