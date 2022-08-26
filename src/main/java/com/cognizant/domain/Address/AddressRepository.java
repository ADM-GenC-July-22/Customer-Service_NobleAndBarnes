package com.cognizant.domain.Address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;


@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	@Modifying
	@Query("update Address set unitNumber = ?1, streetName = ?2, city = ?3, state = ?4, zipCode = ?5 where addressID = ?6")
	void updateAddress(Integer unitNumber, String streetName, String city, String state, Integer zipCode, Integer addressID);
	
	
}
