package it.uniroma3.facade;

import it.uniroma3.model.*;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
		Customer customer = new Customer(firstName, lastName, email, phoneNumber, password, dateOfBirt, registrationDate, address);
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

	public void updateCustomer(Customer customer) {
		entityManager.getTransaction();
        entityManager.merge(customer);
	}

	public void deleteCustomer(Long id) {
		Customer customer = entityManager.find(Customer.class, id);
        entityManager.remove(customer);
	}
}