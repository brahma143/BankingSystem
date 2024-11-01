package com.bank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.Entity.Customers;
import com.bank.Service.CustomersService;

@RestController
public class CustomersController {

	@Autowired
	CustomersService customersService;
	
	public ResponseEntity<Customers> saveCustomer(@RequestBody Customers customers){
		
		return new ResponseEntity<>(customersService.addCustomers(customers),HttpStatus.OK);
	}
}
