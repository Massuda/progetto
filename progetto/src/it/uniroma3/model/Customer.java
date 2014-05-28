package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//@NamedQuery(name = "findAllCustomers", query = "SELECT c FROM Customer c") 
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	private String email;
	private String phoneNumber;
	private String password;
	@Temporal(TemporalType.DATE)
	private Date dateOfBirt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	
	@OneToOne (cascade = {CascadeType.ALL})
	private Address address;
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;
	
	public Customer() {
	}

	public Customer(String firstName, String lastName, String email,
			String phoneNumber, String password, Date dateOfBirt, Date registrationDate, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.dateOfBirt = dateOfBirt;
		this.registrationDate = registrationDate;
		this.address = address;
		this.orders = new ArrayList<Order>();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setAddress(Address address){
		this.address = address;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Date getDateOfBirt() {
		return dateOfBirt;
	}
	
	public void setDateOfBirt(Date dateOfBirt) {
		this.dateOfBirt = dateOfBirt;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
		
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Address getAddress() {
		return address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", dateOfBirt=" + dateOfBirt
				+ ", registrationDate=" + registrationDate + "]";
	}
}
