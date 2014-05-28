package it.uniroma3.facade;

import it.uniroma3.model.*;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class ProductFacade {
	
	@PersistenceContext(unitName = "progetto")
    private EntityManager entityManager;

	public ProductFacade() {
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Product createProduct(String name, String code, Float price, String description, int quantity) {
		Product product = new Product(name, price, description, code, quantity);
		entityManager.persist(product);
		return product;
	}
	
	public Product getProduct(Long id) {
	    Product product = entityManager.find(Product.class, id);
		return product;
	}
	
	public List<Product> getAllProducts() {
        CriteriaQuery<Product> cq = entityManager.getCriteriaBuilder().createQuery(Product.class);
        cq.select(cq.from(Product.class));
        List<Product> products = entityManager.createQuery(cq).getResultList();
		return products;
	}

	public void updateProduct(Product product) {
		entityManager.getTransaction();
        entityManager.merge(product);
	}

	public void deleteProduct(Long id) {
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
	}
}