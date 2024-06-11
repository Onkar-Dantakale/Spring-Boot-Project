package com.example.app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Customer;
import com.example.app.repository.CustomerRepository;
import com.example.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	public CustomerRepository customerRepository;

	@Override
	public Customer saveAll(Customer customer) {
		
				
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getListById(Long id) {
		
		Optional<Customer> findCustomer=customerRepository.findById(id);
	if (findCustomer.isPresent()) {
		return findCustomer.get();
	} else {
		return null;

	}
		
	}

	@Override
	public Customer delete(Long id) {
		Optional<Customer>findCusto=customerRepository.findById(id);
		if (findCusto.isPresent()) {
			Customer customerExist=findCusto.get();
			customerRepository.deleteById(id);
			return customerExist;
			
		} else {
			return null;


		}
		
	}

	@Override
	public Customer update(Long id, Customer updateCustomer) {
		Optional<Customer>findCusto=customerRepository.findById(id);
		if (findCusto.isPresent()) {
			Customer customerExist=findCusto.get();
			customerExist.setId(updateCustomer.getId());
			customerExist.setName(updateCustomer.getName());
			customerExist.setEmail(updateCustomer.getEmail());
			return customerRepository.save(customerExist);
			
		} else {
			return null;


		}
		
	}

}
