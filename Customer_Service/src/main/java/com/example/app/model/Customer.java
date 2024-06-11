package com.example.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Customer_Details")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	/*
	 * public long getId() { return id; } public void setId(long id) { this.id = id;
	 * } public String getName() { return name; } public void setName(String name) {
	 * this.name = name; } public String getEmail() { return email; } public void
	 * setEmail(String email) { this.email = email; }
	 * 
	 * @Override public String toString() { return "Customer [id=" + id + ", name="
	 * + name + ", email=" + email + "]"; }
	 */
	
	
	
	

}
