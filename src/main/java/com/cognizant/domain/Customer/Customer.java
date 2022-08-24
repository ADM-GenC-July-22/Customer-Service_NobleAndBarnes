package com.cognizant.domain.Customer;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cognizant.domain.Address.Address;



@Entity
public class Customer {

   // DATA FIELDS
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int customerID;
    @Column(name="customerFirstName")
    private String firstName;
    @Column(name="customerLastName")
    private String lastName;
    private Long phoneNumber;
    private String email;
    
    
    // Customer to Address
    @ManyToOne
    @JoinColumn(name="addressID")
    public Address addressObj; // Used to reference addressId()
    
    

    // CONSTRUCTORS
    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Customer(int customerID, String firstName, String lastName, Long phoneNumber, String email, Address addressObj) {
        super();
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addressObj = addressObj;
    }



   // GETTERS AND SETTERS
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Address getAddressObj() {
        return addressObj;
    }
    public void setAddressObj(Address addressObj) {
        this.addressObj = addressObj;
    }
    
}