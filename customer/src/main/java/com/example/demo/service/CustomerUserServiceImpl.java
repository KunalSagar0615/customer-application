package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerUserServiceImpl implements UserDetailsService {

	@Autowired
	private CustomerRepository cr;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Customer c=cr.findByName(username).orElseThrow(()->
				new UsernameNotFoundException("INVALID USERNAME")
				);
		
		return User.builder()
				.username(username)
				.password(c.getPassword())
				.authorities("ROLE_CUSTOMER")
				.build();
	}

}
