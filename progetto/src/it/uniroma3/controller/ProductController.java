package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.model.Product;
import it.uniroma3.model.Provider;
import it.uniroma3.facade.ProductFacade;

@ManagedBean
public class ProductController {

	@EJB
	private ProductFacade productFacade;
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private Float price;
	private String description;
	private String code;
	private int quantity;
	private List<Provider> providers;
	private Product product;
	private List<Product> products;
	
	public String createProduct() {
		this.product = productFacade.createProduct(name, code, price, description, quantity);
		return "product";
	}
	
	public String listProducts() {
		this.products = productFacade.getAllProducts();
		return "products";
	}

	public String findProduct() {
		this.product = productFacade.getProduct(id);
		return "product";
	}
	
	public String deleteProduct() {
		productFacade.deleteProduct(id);
		this.products = productFacade.getAllProducts();
		return "products";
	}
	
//	public String prepareUpdateProduct() {
//		this.product = productFacade.getProduct(id);
//		return "updateProduct";
//	}
	
//	public String updateProduct() {
//		this.product.setName(name);
//		this.product.setDescription(description);
//		this.product.setPrice(price);
//		productFacade.updateProduct(this.product);
//		return "product";
//	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public ProductFacade getProductFacade() {
		return productFacade;
	}

	public void setProductFacade(ProductFacade productFacade) {
		this.productFacade = productFacade;
	}

	public String getName() {
		return name;
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
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
	
	
//	public String updateProduct() {
//		this.product = productFacade.updateProduct(product);
//		return "product";
//	}
	
}
