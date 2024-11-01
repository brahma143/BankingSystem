package com.bank.Controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.DTO.AccountDTO;
import com.bank.Entity.Account;
import com.bank.Entity.Transaction;
import com.bank.Repository.ContactFormRepo;
import com.bank.Service.AccountService;
import com.bank.ServiceImpl.AccountImpl;
import com.bank.Entity.ContactForm;

@Controller
@RequestMapping("/")
public class AccountController2 {

	@Autowired
	ContactFormRepo contactFormRepo;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	AccountImpl accountImpl;
	//Dash Board
	@GetMapping("/dash")
	public String dashBoard(Model model) {
		model.addAttribute("account",new Account());
		return "dashboard";
	}
	
	@PostMapping("/saveAll")
	public String saveAdmin(@ModelAttribute("admin") Account account ) {
		 
		accountService.saveCustomers(account);
		System.out.println("Details added");
		return "redirect:/dash";
	}
	 // login Users
	@GetMapping("/login")
	public String home(Model model) {
		model.addAttribute("account",new Account());
		System.out.println("user logged");
		return "login";
	}
	
	
	@PostMapping("/loginUser")
	  public String userAndPassword(@ModelAttribute("login") Account account ) {
		accountService.findUsername(account);
		  return "redirect:/dash";
	  }
	
	//Register users
	@GetMapping("/register")
	public String registerUser(Model model) {
		model.addAttribute("account", new Account());
		return "register";
	}
	
	@PostMapping("/registerUser")
	public String saveRegister(@ModelAttribute("new") Account account) {
		
		accountService.saveCustomers(account);
		return "redirect:/login";
	}

	@GetMapping("/accounts")
	public String viewAccounts(Model model) {
		
		List<AccountDTO> account = accountService.getAccountNumberAndCname();
		
		model.addAttribute("account", account);
		
		return "accounts";
	}
	
	 // GET method to display the deposit form
    @GetMapping("/deposite")
    public String showDepositForm( Model model) {
        model.addAttribute("accountNumber", new Account());
        return "deposite";  // Return the deposit view to enter the amount
    }
	
    // POST method to process the deposit
    @PostMapping("/deposit/{accountNumber}")
    public String deposit(@PathVariable("accountNumber") String accountNumber,
                          @RequestParam("amount") String amountString,
                          Model model) {
        try {
            BigDecimal amount = new BigDecimal(amountString);  // Convert amount to BigDecimal
            Account account = accountService.deposit(accountNumber, amount);  // Perform deposit
            
            model.addAttribute("account", account);
            model.addAttribute("message", "Deposit successful. New balance: " + account.getBalance());
            return "redirect:/accounts";  // Redirect to a success view or show balance
            
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Invalid amount format.");
            return "deposit";  // Return to deposit view with error message

        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "deposite";  // Return to deposit view if account not found or any other issue
        }
        //return "redirect:/accounts";
}
	
	
	@GetMapping("withdraw/{accountNumber}/{amount}")
	public String withdraw(@PathVariable("accountNumber") String accountNumber,
			@PathVariable("amount") BigDecimal amount, Model model) {
		Account account= accountService.witdraw(accountNumber, amount);
		model.addAttribute(account);
		
		return "withdraw";
		
	}
	
	
	@GetMapping("/transactions")
	public String transactionDetails(Model model) {
		
		List<Transaction> transactions = accountService.gettransactions();
		
		model.addAttribute("transactions", transactions);
		
		return "transactions";
	}
	
	@GetMapping("/contact")
	public String ContactForm(Model model) {
		
		model.addAttribute("contactForm", new ContactForm());
		
		return "contact";
		
	}
	
	@PostMapping("/submitContact")
	public String saveForm(@ModelAttribute("contactForm") ContactForm contactForm) {
		
		contactFormRepo.save(contactForm);
		
		return "redirect:/dash";
	}
}
