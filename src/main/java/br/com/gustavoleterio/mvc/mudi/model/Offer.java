package br.com.gustavoleterio.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal value;
	private LocalDate deliveryDate;
	private String comment;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private PurchaseOrder purchaseOrder;

	public Offer() {
	}

	public Offer(Long id, BigDecimal value, LocalDate deliveryDate, String comment, PurchaseOrder purchaseOrder) {
		this.id = id;
		this.value = value;
		this.deliveryDate = deliveryDate;
		this.comment = comment;
		this.purchaseOrder = purchaseOrder;
	}

	public Offer(Long id, LocalDate deliveryDate, BigDecimal value, String comment) {
		this.id = id;
		this.value = value;
		this.deliveryDate = deliveryDate;
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

}
