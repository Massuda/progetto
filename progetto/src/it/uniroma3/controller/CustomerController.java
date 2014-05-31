package it.uniroma3.controller;

import it.uniroma3.facade.*;
import it.uniroma3.model.*;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

	@ManagedBean
	public class CustomerController {

		@EJB
		private CustomerFacade customerFacade;
		@ManagedProperty(value="#{param.id}")
		private Long id;
		private String firstName;
		private String lastName;
		private String email;
		private String phoneNumber;
		private String password;
		private Date dateOfBirth;
		private Date registrationDate;
		private Address address;
		private List<Order> orders;
		private Customer customer;
		private List<Customer> customers;
		
		public String createCustomer() {
			this.customer = customerFacade.createCustomer(firstName, lastName, email, phoneNumber, password, dateOfBirth, registrationDate, address);
			return "customer";
		}
		
		public String listCustomers() {
			this.customers = customerFacade.getAllCustomers();
			return "customers";
		}
		
		public String listOrders(){
			this.orders = customerFacade.getAllMyOrders(this.id);
			return "customerOrders";
		}

		public String findCustomer() {
			this.customer = customerFacade.getCustomer(id);
			return "customer";
		}
		
		public String deleteCustomer() {
			customerFacade.deleteCustomer(id);
			this.customers = customerFacade.getAllCustomers();
			return "customers";
		}
		
		public String closeOrder(){
			return "customerOrders";
		}
		
//		public String prepareUpdateProduct() {
//			this.product = productFacade.getProduct(id);
//			return "updateProduct";
//		}
		
//		public String updateProduct() {
//			this.product.setName(name);
//			this.product.setDescription(description);
//			this.product.setPrice(price);
//			productFacade.updateProduct(this.product);
//			return "product";
//		}
		

//		public String updateProduct() {
//			this.product = productFacade.updateProduct(product);
//			return "product";
//		}
		

		public CustomerFacade getCustomerFacade() {
			return customerFacade;
		}

		public void setCustomerFacade(CustomerFacade customerFacade) {
			this.customerFacade = customerFacade;
		}

		public Long getId() {
			return id;
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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}

		public Date getRegistrationDate() {
			return registrationDate;
		}

		public void setRegistrationDate(Date registrationDate) {
			this.registrationDate = registrationDate;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public List<Order> getOrders() {
			return orders;
		}

		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public List<Customer> getCustomers() {
			return customers;
		}

		public void setCustomers(List<Customer> customers) {
			this.customers = customers;
		}

}
