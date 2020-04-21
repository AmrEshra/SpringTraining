package code.dao;

import java.util.List;

import code.orm.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	public Customer getCustomerById(Long id);
	public void saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public void deleteCustomer(Long id);
}
