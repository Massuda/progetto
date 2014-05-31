package it.uniroma3.facade;

import it.uniroma3.model.*;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class ProviderFacade {

	@PersistenceContext(unitName = "progetto")
	private EntityManager entityManager;

	public ProviderFacade() {
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Provider createProvider(String name, String phoneNumber, String email, String vatin, Address address) {
		Provider provider = new Provider(name, phoneNumber, email, vatin, address);
		entityManager.persist(provider);
		return provider;
	}

	public Provider getProvider(Long id) {
		Provider provider = entityManager.find(Provider.class, id);
		return provider;
	}

	public List<Provider> getAllProviders() {
		CriteriaQuery<Provider> cq = entityManager.getCriteriaBuilder().createQuery(Provider.class);
		cq.select(cq.from(Provider.class));
		List<Provider> providers = entityManager.createQuery(cq).getResultList();
		return providers;
	}

	public void updateProvider(Provider provider) {
		entityManager.getTransaction();
		entityManager.merge(provider);
	}

	public void deleteProvider(Long id) {
		Provider provider = entityManager.find(Provider.class, id);
		entityManager.remove(provider);
	}
}