package br.com.gustavoleterio.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Parent;

import br.com.gustavoleterio.mvc.mudi.model.Offer;

public class OfferRequisition {
	private Long id;
	@NotNull
	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$")
	private String value;
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	@NotNull
	private String deliveryDate;
	private String comment;

	public OfferRequisition(Long id, String value, String deliveryDate, String comment) {
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Offer toOffer() {
		return new Offer(id, LocalDate.parse(deliveryDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				new BigDecimal(value), comment);
	}
}
