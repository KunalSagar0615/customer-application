package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="online_customer")//to set db table name explicitly
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	@Pattern(regexp = "^[6-9]\\d{9}$", message="INVALID MOBILE NUMBER")
	@NotBlank(message="MOBILE VANNOT BE EMPTY")
	private String mob;
	@Email(message="INVALID EMAIL")
	@NotBlank
	private String email;
	@NotBlank(message="INVALID ADDRESS")
	private String address;
	//@Pattern(regexp="^(?=.*[A-Z])(?=.*\\d)(?=.*[@#%&+=!]).{8,}$",message="WRONG PASSWORD")
	private String password;
	
	
	
	
	
	
	
	
	
	
	
	
	
}
