package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Column;

@Entity
@NamedQuery(name = "findAllProducts", query = "SELECT p FROM Product p")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	private Float price;
	@Column(length = 2000)
	private String description;
	@Column(unique = true, nullable = false)
	private String code;
	private int quantity;
	@ManyToMany(mappedBy = "products")
	private List<Provider> providers;
	
	public Product() {
	}

	public Product (String name, Float price, String description, String code, int quantity) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.code = code;
		this.quantity = quantity;
		this.providers = new ArrayList<Provider>();
	}

	//          Getters & Setters        

	public Long getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCode() {
		return this.code;
	}

	public void setCode (String code) {
		this.code = code;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantyty() {
		return quantity;
	}

	public void setQuantyty(int quantyty) {
		this.quantity = quantyty;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", description=" + description + ", code=" + code
				+ ", providers=" + providers + "]";
	}
	

}