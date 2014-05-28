package it.uniroma3.controller;

import it.uniroma3.facade.*;
import it.uniroma3.model.*;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Column;


@ManagedBean
public class AdministratorController {

	@EJB
	private AdministratorFacade administratorFacade;
	@ManagedProperty(value="#{param.id}")
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	private String password;
	private Administrator administrator;
	private List<Administrator> administrators;

	public String createAdministrator() {
		this.administrator = administratorFacade.createAdministrator(firstName, lastName, password);
		return "product";
	}

	public String listAdministrators() {
		this.administrators = administratorFacade.getAllAdministrators();
		return "products";
	}

	public String findAdministrator() {
		this.administrator = administratorFacade.getAdministrator(id);
		return "product";
	}

	public String deleteAdministrator() {
		administratorFacade.deleteAdministrator(id);
		this.administrators = administratorFacade.getAllAdministrators();
		return "products";
	}

	public AdministratorFacade getAdministratorFacade() {
		return administratorFacade;
	}

	public void setAdministratorFacade(AdministratorFacade administratorFacade) {
		this.administratorFacade = administratorFacade;
	}


	//		public String prepareUpdateProduct() {
	//			this.product = productFacade.getProduct(id);
	//			return "updateProduct";
	//		}

	//		public String updateProduct() {
	//			this.product.setName(name);
	//			this.product.setDescription(description);
	//			this.product.setPrice(price);
	//			productFacade.updateProduct(this.product);
	//			return "product";
	//		}


	//		public String updateProduct() {
	//			this.product = productFacade.updateProduct(product);
	//			return "product";
	//		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public List<Administrator> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(List<Administrator> administrators) {
		this.administrators = administrators;
	}

}
