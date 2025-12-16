package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;

public class CustomerDTOMapper {

	public static List<CustomerDTO> convertIntoDTO(List<Customer> c){
		List<CustomerDTO> dto=new ArrayList<>();
		
		for (Customer x : c) {
			dto.add(new CustomerDTO(x.getId(),x.getName(),x.getEmail(),x.getAddress(),x.getMob()));
		}
		return dto;
	}

	public static CustomerDTO convertIntoDTO(Customer c){
		CustomerDTO dto=new CustomerDTO(
				c.getId(),
				c.getName(),
				c.getEmail(),
				c.getAddress(),
				c.getMob()
				);
		
		return dto;
	}
}
