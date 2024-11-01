package com.bank.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.Entity.Customers;
import com.bank.Repository.CustomersRepo;
import com.bank.Service.CustomersService;

@Service
public class CutomersImpl implements CustomersService {

	CustomersRepo customersRepo;
	
	@Override
	public Customers addCustomers(Customers customers) {
		// TODO Auto-generated method stub
		   
		Customers cust = customersRepo.save(customers);
		return cust;
	}

	@Override
	public List<Customers> allCustomers() {
		// TODO Auto-generated method stub
		
		   List<Customers> cust=customersRepo.findAll();
		return cust;
	}

	@Override
	public Customers getByCustomerId(long cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customers updateCustomer(Customers customers, long cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteId(long cid) {
		// TODO Auto-generated method stub
	
		
	}

}
