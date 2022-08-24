package com.cognizant.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Modifying
	@Query("update Customer set phoneNumber = ?1, customerFirstName = ?2, customerLastName = ?3, email = ?4 where customerID = ?5")
	void updateCustomer(Long phoneNumber, String customerFirstName, String customerLastName, String email, Integer customerId);
}
