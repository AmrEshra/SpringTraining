package com.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.dao.CustomerRepository;
import com.entity.Customer;
import com.exceptions.NotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

    @Autowired
    EntityManagerFactory emf;

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
	public List<Customer> findByFirstName(String name) {
		return customerRepository.findByFirstName(name);
	}
	
	@Override
	public List<Customer> findByLastName(String name) {
		return customerRepository.findByLastName(name);
	}
	
	@Override
	public List<Customer> findByEmail(String email) {
		
		EntityManager entityManager = emf.createEntityManager();
        //em.getTransaction().begin( );

		TypedQuery<Customer> query = entityManager.createNamedQuery("customer_findByEmail", Customer.class);
        query.setParameter("P_EMIAL", "%" + email + "%");
        List<Customer> list = query.getResultList();
        entityManager.close();
        return list;
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

	@Override
	public int countAll() {
		return customerRepository.countAll();
	}

}
