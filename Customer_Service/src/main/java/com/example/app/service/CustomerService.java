package com.example.app.service;

import java.util.List;

import com.example.app.model.Customer;

public interface CustomerService {
	
	public Customer saveAll(Customer customer);
	
	public List<Customer> getAll();
	
	public Customer getListById(Long id);
	
	public Customer delete(Long id);
	
	public Customer update(Long id, Customer updateCustomer);

}
