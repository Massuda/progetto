package it.uniroma3.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.model.Address;
import it.uniroma3.facade.AddressFacade;

@ManagedBean
public class AddressController {

	@EJB
	private AddressFacade addressFacade;
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private Address address;
	private List<Address> addresses;

	public String createAddress() {
		this.address = addressFacade.createAddress(street, city, state, zipcode, country);
		return "product";
	}

	public String listProducts() {
		this.addresses = addressFacade.getAllAddresses();
		return "products";
	}

	public String findProduct() {
		this.address = addressFacade.getAddress(id);
		return "product";
	}

	public String deleteAddress() {
		addressFacade.deleteAddress(id);
		this.addresses = addressFacade.getAllAddresses();
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

	//	public String updateProduct() {
	//	this.product = productFacade.updateProduct(product);
	//	return "product";
	//}
	public Long getId() {
		return id;
	}

	public AddressFacade getAddressFacade() {
		return addressFacade;
	}

	public void setAddressFacade(AddressFacade addressFacade) {
		this.addressFacade = addressFacade;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public AddressFacade getProductFacade() {
		return addressFacade;
	}

	public void setProductFacade(AddressFacade addressFacade) {
		this.addressFacade = addressFacade;
	}
}