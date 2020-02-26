package code.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import code.dao.CustomerDAO;
import code.orm.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerdao;
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		return customerdao.getCustomers();
	}
	
	@Transactional
	@Override
	public Customer getCustomerById(Long id) {
		return customerdao.getCustomerById(id);
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerdao.saveCustomer(theCustomer);
	}
	
	@Override
	@Transactional
	public void deleteCustomer(Customer theCustomer) {
		customerdao.deleteCustomer(theCustomer);
	}

}
