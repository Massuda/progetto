package it.uniroma3.facade;

import it.uniroma3.model.*;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class CustomerFacade {

	@PersistenceContext(unitName = "progetto")
	private EntityManager entityManager;

	public CustomerFacade() {
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Customer createCustomer(String firstName, String lastName, String email, String phoneNumber, String password, Date dateOfBirt, Date registrationDate, Address address) {
		Customer customer = new Customer(firstName, lastName, email, phoneNumber, password, dateOfBirt, address);
		entityManager.persist(customer);
		return customer;
	}

	public Customer getCustomer(Long id) {
		Customer customer = entityManager.find(Customer.class, id);
		return customer;
	}

	public List<Customer> getAllCustomers() {
		CriteriaQuery<Customer> cq = entityManager.getCriteriaBuilder().createQuery(Customer.class);
		cq.select(cq.from(Customer.class));
		List<Customer> customers = entityManager.createQuery(cq).getResultList();
		return customers;
	}
	
	public List<Order> getAllMyOrders(Long id){
		
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
//		Root<Customer> customer = cq.from(Customer.class);
//		Join<Customer, Order> o = customer.join("orders");
//		cq.where(cb.equal(customer.get("name"), "Braun")).select(customer);
//		
//		List<Customer> customers = entityManager.createQuery(cq).getResultList();

		TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM order o WHERE o.customer = :id", Order.class);
		List<Order> orders = query.getResultList();
		
		
		return orders;
	}

	public void updateCustomer(Customer customer) {
		entityManager.getTransaction();
		entityManager.merge(customer);
	}

	public void deleteCustomer(Long id) {
		Customer customer = entityManager.find(Customer.class, id);
		entityManager.remove(customer);
	}


}
