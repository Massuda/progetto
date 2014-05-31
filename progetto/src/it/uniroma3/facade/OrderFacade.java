package it.uniroma3.facade;

import java.util.Date;
import java.util.List;

import it.uniroma3.model.Customer;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderLine;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class OrderFacade {
	@PersistenceContext(unitName = "progetto")
	private EntityManager entityManager;

	public OrderFacade(){
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Order createOrder(Customer customer){
		Order order = new Order(customer);
		entityManager.persist(order);
		return order;
	}

	public Order getOrder(Long id){
		return entityManager.find(Order.class, id);
	}

	public List<Order> getAllOrders(){
		CriteriaQuery<Order> cq = entityManager.getCriteriaBuilder().createQuery(Order.class);
		cq.select(cq.from(Order.class));
		List<Order> orders = entityManager.createQuery(cq).getResultList();
		return orders;
	}

	public List<Order> getAllCloseOrders(){
		TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM order o WHERE o.chiuso = true", Order.class);
		List<Order> orders = query.getResultList();
		return orders;
	}

	public void updateOrder(Order order) {
		entityManager.getTransaction();
		entityManager.merge(order);
	}

	public void deleteOrder(Long id) {
		Order order = entityManager.find(Order.class, id);
		entityManager.remove(order);
	}

	public void closeOrder(Long id){
		Order order = entityManager.find(Order.class, id);
		order.setCloseTime(new Date());
		order.setChiuso(true);
		order.setAperto(false);
		this.updateOrder(order);		
	}

	public void sendOrder(Long id){
		Order order = entityManager.find(Order.class, id);
		List<OrderLine> orderLines = order.getOrderLines();
		boolean quantitSuff = true;

		for(OrderLine o : orderLines)
			if(o.getQuantity() > o.getProduct().getQuantity())
				quantitSuff = false;
		if(quantitSuff){		
			order.setEvaso(true);
			order.setChiuso(false);
			order.setSpedictionTime(new Date());
		} else{
			order.setSospeso(true);
		}

		this.updateOrder(order);
	}

}
