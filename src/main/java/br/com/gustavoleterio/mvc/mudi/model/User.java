package br.com.gustavoleterio.mvc.mudi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	private String username;
	private String password;
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
