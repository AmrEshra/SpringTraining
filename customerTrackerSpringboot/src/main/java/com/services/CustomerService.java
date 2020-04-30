package com.services;

import java.util.List;

import com.entity.Customer;

public interface CustomerService {
	
	public List<Customer> findAll();
	public List<Customer> findAllSorted();
	public Customer findById(Long theId);
	public void save(Customer theEmployee);
	public void deleteById(Long theId);
}
