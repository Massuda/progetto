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
	@ManyToOne
	private Customer customer;
	
	@OneToMany //(fetch = FetchType.EAGER , cascade = {CascadeType.REMOVE})
	@JoinColumn(name = "orders_id")
	private List<OrderLine> orderLines;
	
	public Order() {
	}
	
	public Order(Long id, Date creationTime) {
		this.id = id; //sicuro l'id non va messo!!!
		this.creationTime = creationTime;
	}
	
	 /*public Order(Date creationtime){
	    	this.creationtime = creationtime;
	    	this.orderLines = new ArrayList<OrderLine>();
	    }*/ 
	
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
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", creationTime=" + creationTime + "]";
	}
	
	

}
