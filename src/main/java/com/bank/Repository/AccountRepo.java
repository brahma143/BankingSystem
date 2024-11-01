package com.bank.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.bank.DTO.AccountDTO;
import com.bank.Entity.Account;

@Repository
@EnableJpaRepositories
public interface AccountRepo extends JpaRepository<Account, Long>{

	Optional<Account> findByAccountNumber(String accountNumber);
	
	//Account findByUsernameAndPassword(String cname, String password);
	
	Account findByCname(String cname);
	
	@Query( value="select new com.bank.DTO.AccountDTO(a.accountNumber,a.cname) from Account a")
	public List<AccountDTO> findAccountNumberAndCname();

	//List<AccountDTO> findAccountNumberAndCname();

	
}
