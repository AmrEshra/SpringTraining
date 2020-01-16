package code.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import code.dao.CustomerDAO;
import code.orm.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerdao;
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		return customerdao.getCustomers();
	}

}
