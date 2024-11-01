package com.bank.Service;

import java.util.List;

import com.bank.Entity.Customers;

public interface CustomersService {

	public Customers addCustomers(Customers customers);
	
	//get all customers
	public List<Customers> allCustomers();
	
	public Customers getByCustomerId(long cid);
	
	public Customers updateCustomer(Customers customers, long cid);
	
	//delete customer id
	public void deleteId(long cid);
}
