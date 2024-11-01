package com.bank.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.Entity.ContactForm;

public interface ContactFormRepo extends JpaRepository<ContactForm, String> {

}
