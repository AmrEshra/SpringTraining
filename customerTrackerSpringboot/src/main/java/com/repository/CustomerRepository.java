package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	
	@Query("SELECT c FROM Customer c WHERE LOWER(c.firstName) = LOWER(:P_FIRST_NAME)")
    List<Customer> findByFirstName(@Param("P_FIRST_NAME") String firstName);
	
	@Query(value = "SELECT count(*) FROM CUSTOMERS c", nativeQuery = true)
    int countAll();
	
	List<Customer> findByLastName(@Param("P_LAST_NAME") String lastName);
		
}
