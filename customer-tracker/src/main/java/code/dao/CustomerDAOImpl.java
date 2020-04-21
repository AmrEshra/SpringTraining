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

	@Override
	public Customer getCustomerById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = (Customer) currentSession.createQuery("from Customer where id = " + id).getResultList().get(0);

		return customer;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(theCustomer);
	}

	@Override
	public void deleteCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(theCustomer);
	}
	
	@Override
	public void deleteCustomer(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.delete(getCustomerById(id));
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(customer);
	}
}
