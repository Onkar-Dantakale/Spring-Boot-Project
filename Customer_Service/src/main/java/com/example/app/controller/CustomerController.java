package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Customer;
import com.example.app.service.CustomerService;

@RestController
@RequestMapping("/Customers")
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;
	
	@PostMapping("/SaveData")
	public ResponseEntity<?>saveAll(@RequestBody Customer customer){
		Customer saveData=customerService.saveAll(customer);
		if (saveData!= null) {
			
			return ResponseEntity.status(HttpStatus.CREATED).body("Data Saved Successfully");
			
		} else {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save Data");

		}
	}
	
	@GetMapping("/GetList")
	public ResponseEntity<List<Customer>>getAll(){
		List<Customer>getData=customerService.getAll();
			return ResponseEntity.ok(getData);
		
	}
	
	@GetMapping("/GetListById/{id}")
	public ResponseEntity<?>getListById(@PathVariable Long id){
		Customer getDatabyId=customerService.getListById(id);
		if (getDatabyId!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(getDatabyId);
			
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id");

		}
	}
	
	@DeleteMapping("/Delete/{id}")
	public ResponseEntity<?>delete(@PathVariable Long id){
		Customer deleteData=customerService.delete(id);
		if (deleteData!=null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Data Deleted Successfully");
			
		} else {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID");

		}
	}
	
	@PutMapping("/Update/{id}")
	public ResponseEntity<?>update(@PathVariable Long id, @RequestBody Customer updateCustomer){
		Customer updateData=customerService.update(id, updateCustomer);
		if (updateData!=null) {
			return ResponseEntity.status(HttpStatus.OK).body("Data Updated Successfully");
			
		} else {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id");

		}
	}
	
	

}
