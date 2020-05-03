package com.RESTcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exceptions.NotFoundException;
import com.entity.Customer;
import com.services.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	
	CustomerService customerService;

	@Autowired
	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		
//		return customerService.findAll();
		return customerService.findAllSorted();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		
		try {
			return customerService.findById(id);
		}catch(NotFoundException e) {
			throw new NotFoundException("Not Data Found");
		}
	}
	
	@GetMapping("/customers/fname/{name}")
	public List<Customer> getCustomerByFirstName(@PathVariable String name) {

		return customerService.findByFirstName(name);
	}
	
	@GetMapping("/customers/lname/{name}")
	public List<Customer> getCustomerByLastName(@PathVariable String name) {

		return customerService.findByLastName(name);
	}
	
	@GetMapping("/customers/email/{email}")
	public List<Customer> getCustomerByEmail(@PathVariable String email) {

		return customerService.findByEmail(email);
	}
	
	@GetMapping("/countCustomers")
	public int getCustomerCount() {

		return customerService.countAll();
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		customerService.save(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		customerService.save(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		
		try {
			customerService.deleteById(id);
			return "Customer deleted";
		}catch(NotFoundException e) {
			throw new NotFoundException("Not Data Found");
			
		}
	}

}
