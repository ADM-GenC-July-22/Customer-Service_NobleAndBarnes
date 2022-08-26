package com.cognizant.domain.Customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.domain.Address.Address;
import com.cognizant.domain.Address.AddressRepository;

@Service
public class CustomerAddressService {
	
	
	private CustomerRepository customerRepo;
	
	
	private AddressRepository addressRepo;


	public CustomerAddressService(CustomerRepository customerRepo, AddressRepository addressRepo) {
		super();
		this.customerRepo = customerRepo;
		this.addressRepo = addressRepo;
	}
	
	// Customer Functions
	public List<Customer> findallCustomers() {
		return customerRepo.findAll();
	}
	public Customer findCustomerByID(int id) {
		return customerRepo.findById(id).get();
	}
	public void deleteCustomerByID(int id) {
		customerRepo.deleteById(id);
		// Deletes address as well
	}
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	public void updateCustomer(Customer cust) {
		customerRepo.updateCustomer(cust.getPhoneNumber(), cust.getFirstName(), cust.getLastName(), cust.getEmail(), cust.getCustomerID());
		Address custAddress = cust.getAddressObj();
		addressRepo.updateAddress(custAddress.getUnitNumber(), custAddress.getStreetName(), custAddress.getCity(), custAddress.getState(), custAddress.getZipCode(), custAddress.getAddressID());

	}

	public List<Customer> findCustomerByPhoneNumber(long phoneNumber) { 
		return customerRepo.findByPhoneNumber(phoneNumber); 
	}

	
	// Address Functions
	public Address showCustomerAddress(int id) {
		return addressRepo.findById(id).get();
	}

	
	public Address createAddress(Address add) {
		addressRepo.save(add);
		return add;
	}
	
	// Repository Getters and Setters
	public AddressRepository getAddressRepo() {
		return addressRepo;
	}
	public void setAddressRepo(AddressRepository addressRepo) {
		this.addressRepo = addressRepo;
	}
	public CustomerRepository getCustomerRepo() {
		return customerRepo;
	}
	public void setCustomerRepo(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}
	
	
}
