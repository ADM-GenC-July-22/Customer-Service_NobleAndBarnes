package com.cognizant.domain.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.domain.Address.Address;
import com.cognizant.domain.Address.AddressRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerAddressWebController {
	
	// Kill Port Cmd
	// npx kill-port 8080
	
	private CustomerAddressService custService;
	
	public CustomerAddressWebController(CustomerAddressService custService) {
		super();
		this.custService = custService;
	}
	public CustomerAddressService getCustService() {
		return custService;
	}
	public void setCustService(CustomerAddressService custService) {
		this.custService = custService;
	}
	
	// CUSTOMERS TEST CONTROLLER
	// Show All Customers GOOD
	@GetMapping("/customers")
	public List<Customer> retrieveAllCustomers() {
		return custService.findallCustomers();
	}
	// Find by ID GOOD
	@GetMapping("/customers/{id}")
	public Customer retrieveCustomer(@PathVariable int id) {
		return custService.findCustomerByID(id);
	}
	// Delete Mapping by ID GOOD
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		custService.deleteCustomerByID(id);
	}
	// Create a Customer Mapping  Good
	@PostMapping("/customers")
	public void createCustomer(@RequestBody Customer customer) {
		custService.addCustomer(customer);
	}
	// Update a Customer Mapping and Address
	@PutMapping("/customers")
	@Transactional
	public void updateCustomers(@RequestBody Customer cust) {
		custService.updateCustomer(cust);
	}

	// ADDRESS CONTROLLERS
	// Find the customer Address
	@GetMapping("/customers/{id}/address")
	public Address showAddress(@PathVariable int id) {
		Customer customerTemp;
		customerTemp = custService.findCustomerByID(id);
		return custService.showCustomerAddress(customerTemp.getAddressObj().getAddressID());
	}
	
	// Find Customer by Phone Number (6513585681)
	@GetMapping("/customers/{phoneNumber}/phonenumber") 
	public Customer retrieveCustomerByPhoneNumber(@PathVariable long phoneNumber) { 
			List<Customer> customerlist = custService.findCustomerByPhoneNumber(phoneNumber);
			return customerlist.get(0);
	 }
	 
	
	
}
