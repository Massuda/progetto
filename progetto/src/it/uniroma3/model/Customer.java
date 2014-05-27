package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"firstName", "lastName"}))
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
	@Temporal(TemporalType.DATE)
	private Date dateOfBirt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;
	@OneToOne
	private Address address;
	@OneToMany(mappedBy = "customer")
	private List<Order> orders;
	
	public Customer() {
	}

	public Customer(Long id, String firstName, String lastName, String email,
			String phoneNumber, Date dateOfBirt, Date registrationDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirt = dateOfBirt;
		this.registrationDate = registrationDate;
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
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", dateOfBirt=" + dateOfBirt
				+ ", registrationDate=" + registrationDate + "]";
	}
}