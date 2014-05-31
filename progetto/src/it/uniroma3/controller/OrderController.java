package it.uniroma3.controller;

import it.uniroma3.facade.OrderFacade;
import it.uniroma3.model.*;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


@ManagedBean
public class OrderController {

	@EJB
	private OrderFacade orderFacade;
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Date creationTime;
	private Date closeTime;
	private Date spedictionTime;
	private boolean aperto;
	private boolean chiuso = false;
	private boolean evaso = false;
	private boolean sospeso = false;
	private Customer customer;
	private List<OrderLine> orderLines;
	private Order order;
	private List<Order> orders;
	private List<Order> closeOrders;

	public String createOrder(){
		this.order = this.orderFacade.createOrder(customer);
		return "order";
	}

	public String listOrders(){
		this.orders = this.orderFacade.getAllOrders();
		return "orders";
	}
	
	public String listCloseOrders(){
		this.closeOrders = orderFacade.getAllCloseOrders();
		return "closeOrders";
	}

	public String findOrder() {
		this.order = orderFacade.getOrder(id);
		return "order";
	}

	public String deleteOrder() {
		orderFacade.deleteOrder(id);
		this.orders = orderFacade.getAllOrders();
		return "orders";
	}
	
	public String closeOrder(){
		orderFacade.closeOrder(id);
		return "customerOrders"; // non sono sicura sia giusto tornare alla lista degli ordini del customer.. 
		                         //come prende il customer giusto???
	}
	
	public String sendOrder(){
		orderFacade.sendOrder(id);
		return "closeOrder"; //da decidere
	}

	//	public String prepareUpdateProduct() {
	//	this.product = productFacade.getProduct(id);
	//	return "updateProduct";
	//}

	//public String updateProduct() {
	//	this.product.setName(name);
	//	this.product.setDescription(description);
	//	this.product.setPrice(price);
	//	productFacade.updateProduct(this.product);
	//	return "product";
	//}

	public OrderFacade getOrderFacade() {
		return orderFacade;
	}

	public void setOrderFacade(OrderFacade orderFacade) {
		this.orderFacade = orderFacade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public Date getSpedictionTime() {
		return spedictionTime;
	}

	public void setSpedictionTime(Date spedictionTime) {
		this.spedictionTime = spedictionTime;
	}

	public boolean isAperto() {
		return aperto;
	}

	public void setAperto(boolean aperto) {
		this.aperto = aperto;
	}

	public boolean isChiuso() {
		return chiuso;
	}

	public void setChiuso(boolean chiuso) {
		this.chiuso = chiuso;
	}

	public boolean isEvaso() {
		return evaso;
	}

	public void setEvaso(boolean evaso) {
		this.evaso = evaso;
	}

	public boolean isSospeso() {
		return sospeso;
	}

	public void setSospeso(boolean sospeso) {
		this.sospeso = sospeso;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Order> getCloseOrders() {
		return closeOrders;
	}

	public void setCloseOrders(List<Order> closeOrders) {
		this.closeOrders = closeOrders;
	}

}
