package br.com.gustavoleterio.mvc.mudi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	@Id
	private String username;
	@SuppressWarnings("unused")
	private String password;	
	@SuppressWarnings("unused")
	private Boolean enabledBoolean;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
	private List<PurchaseOrder> purchaseOrders;

	public User() {
	}

	public User(String username, String password, Boolean enabledBoolean, List<PurchaseOrder> purchaseOrders) {
		super();
		this.username = username;
		this.password = password;
		this.enabledBoolean = enabledBoolean;
		this.purchaseOrders = purchaseOrders;
	}
}
