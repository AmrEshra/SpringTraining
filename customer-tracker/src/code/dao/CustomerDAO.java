package code.dao;

import java.util.List;

import code.orm.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

}
