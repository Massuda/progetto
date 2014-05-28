package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.model.Address;
import it.uniroma3.model.Provider;
import it.uniroma3.facade.ProviderFacade;

@ManagedBean
public class ProviderController {

	@EJB
	private ProviderFacade providerFacade;
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private String phoneNumber;
	private String email;
	private String vatin;
	private Address address;
	private Provider provider;
	private List<Provider> providers;
	
	public String createProduct() {
		this.provider = providerFacade.createProvider(name, phoneNumber, email, vatin, address);
		return "product";
	}
	
	public String listProviders() {
		this.providers = providerFacade.getAllProviders();
		return "products";
	}

	public String findProvider() {
		this.provider = providerFacade.getProvider(id);
		return "product";
	}
	
	public String deleteProvider() {
		providerFacade.deleteProvider(id);
		this.providers = providerFacade.getAllProviders();
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

	public ProviderFacade getProviderFacade() {
		return providerFacade;
	}

	public void setProviderFacade(ProviderFacade providerFacade) {
		this.providerFacade = providerFacade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVatin() {
		return vatin;
	}

	public void setVatin(String vatin) {
		this.vatin = vatin;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
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