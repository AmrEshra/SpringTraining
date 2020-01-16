package code.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import code.orm.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {

		// execute query and get result list
		Session currentSession = sessionFactory.getCurrentSession();
		List<Customer> customers = currentSession.createQuery("from Customer").getResultList();

		// return the results
		return customers;
	}

}
