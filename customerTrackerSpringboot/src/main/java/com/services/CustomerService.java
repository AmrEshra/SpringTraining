package com.services;

import java.util.List;

import com.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();
	public List<Customer> findAllSorted();
	public int countAll();
	
	public Customer findById(Long theId);
	public List<Customer> findByFirstName(String firstName);
	public List<Customer> findByLastName(String lastName);
	public List<Customer> findByEmail(String email);
	public void save(Customer theEmployee);
	public void deleteById(Long theId);
}
