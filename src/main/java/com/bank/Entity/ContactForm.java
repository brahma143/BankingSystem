package com.bank.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
//ContactForm.java (Model)
public class ContactForm {
	
	@Id
 private String name;
 private String email;
 private String subject;
 private String message;

 // Getters and Setters
} 