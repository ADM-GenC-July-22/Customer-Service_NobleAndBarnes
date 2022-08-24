package com.cognizant.domain.Address;


import java.util.Set;



import javax.persistence.OneToMany;

import com.cognizant.domain.Customer.Customer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
public class Address {
    // DATA FIELDS
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int addressID;
    private int unitNumber;
    private String streetName;
    private String city;
    private String state;
    private int zipCode;
    
    
    // ISSUE
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Customer> custSet;


    // CONSTRUCTORS
    public Address() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Address(int addressID, int unitNumber, String streetName, String city, String state, int zipCode) {
        super();
        this.addressID = addressID;
        this.unitNumber = unitNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    
    // GETTERS AND SETTERS
    public int getAddressID() {
        return addressID;
    }
    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }
    public int getUnitNumber() {
        return unitNumber;
    }
    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }
    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getZipCode() {
        return zipCode;
    }
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
	public Set<Customer> getCustSet() {
		return custSet;
	}
	public void setCustSet(Set<Customer> custSet) {
		this.custSet = custSet;
	}
	

    
}