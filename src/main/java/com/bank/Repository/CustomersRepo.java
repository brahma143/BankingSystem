package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.Entity.Customers;

@Repository
public interface CustomersRepo extends JpaRepository<Customers, Long> {

}
