package code.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import code.dao.CustomerDAO;
import code.orm.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		// execute query and get result list
		List<Customer> customers = currentSession.createQuery("from Customer").getResultList();

		// return the results
		return customers;
	}

}
