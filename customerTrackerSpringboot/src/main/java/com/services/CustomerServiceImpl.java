package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dao.CustomerRepository;
import com.entity.Customer;
import com.exceptions.NotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	@Override
	public List<Customer> findAllSorted() {
		return customerRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
	}
	
	@Override
	public Customer findById(Long id) {
		Optional<Customer> result = customerRepository.findById(id);
		
//		if (result.isPresent()) {
//			customer = result.get();
//		}
//		else {
//			// we didn't find the employee
//			throw new RuntimeException("Did not find customer id - " + id);
//		}
		
		try {
			return result.get();
		} catch(NotFoundException e) {
			throw new NotFoundException("Did not find customer id - " + id);
		}
	}

	@Override
	public void save(Customer employee) {
		customerRepository.save(employee);
	}

	@Override
	public void deleteById(Long id) {
		customerRepository.deleteById(id);
	}

	

}
