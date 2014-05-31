package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date closeTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date spedictionTime;
	
	private boolean aperto;
	private boolean chiuso = false;
	private boolean evaso = false;
	private boolean sospeso = false;
	
	@ManyToOne
	private Customer customer;

	@OneToMany (fetch = FetchType.EAGER , cascade = {CascadeType.REMOVE})
	@JoinColumn(name = "orders_id")
	private List<OrderLine> orderLines;

	public Order() {
	}

	public Order(Customer customer){
		this.creationTime = new Date();
		this.customer = customer;
		this.aperto = true;
		this.orderLines = new ArrayList<OrderLine>();
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

	@Override
	public String toString() {
		return "Order [creationTime=" + creationTime + ", closeTime="
				+ closeTime + ", spedictionTime=" + spedictionTime
				+ ", aperto=" + aperto + ", chiuso=" + chiuso + ", evaso="
				+ evaso + ", sospeso=" + sospeso + ", customer=" + customer
				+ "]";
	}
}
