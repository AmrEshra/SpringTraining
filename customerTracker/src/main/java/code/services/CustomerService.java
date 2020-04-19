package code.services;

import java.util.List;

import code.orm.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	public Customer getCustomerById(Long id);
	public void saveCustomer(Customer theCustomer);
	public void deleteCustomer(Customer theCustomer);
}
