package it.uniroma3.facade;

import it.uniroma3.model.*;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;


@Stateless
public class AdministratorFacade {
	
	@PersistenceContext(unitName = "progetto")
    private EntityManager entityManager;

	public AdministratorFacade() {
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Administrator createAdministrator(String firstName, String lastName, String password) {
		Administrator administrator = new Administrator(firstName, lastName, password);
		entityManager.persist(administrator);
		return administrator;
	}
	
	public Administrator getAdministrator(Long id) {
		Administrator administrator = entityManager.find(Administrator.class, id);
		return administrator;
	}
	
	public List<Administrator> getAllAdministrators() {
        CriteriaQuery<Administrator> cq = entityManager.getCriteriaBuilder().createQuery(Administrator.class);
        cq.select(cq.from(Administrator.class));
        List<Administrator> administrators = entityManager.createQuery(cq).getResultList();
		return administrators;
	}

	public void updateAdministrator(Administrator administrator) {
		entityManager.getTransaction();
        entityManager.merge(administrator);
	}

	public void deleteAdministrator(Long id) {
		Administrator administrator = entityManager.find(Administrator.class, id);
        entityManager.remove(administrator);
	}

}
