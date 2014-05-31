package it.uniroma3.facade;

import it.uniroma3.model.*;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class AddressFacade {

	@PersistenceContext(unitName = "progetto")
	private EntityManager entityManager;

	public AddressFacade() {
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Address createAddress(String street, String city, String state, int zipcode, String country) {
		Address address = new Address(street, city, state, zipcode, country);
		entityManager.persist(address);
		return address;
	}

	public Address getAddress(Long id) {
		Address address = entityManager.find(Address.class, id);
		return address;
	}

	public List<Address> getAllAddresses() {
		CriteriaQuery<Address> cq = entityManager.getCriteriaBuilder().createQuery(Address.class);
		cq.select(cq.from(Address.class));
		List<Address> addresses = entityManager.createQuery(cq).getResultList();
		return addresses;
	}

	public void updateAddress(Address address) {
		entityManager.getTransaction();
		entityManager.merge(address);
	}

	public void deleteAddress(Long id) {
		Address address = entityManager.find(Address.class, id);
		entityManager.remove(address);
	}
}