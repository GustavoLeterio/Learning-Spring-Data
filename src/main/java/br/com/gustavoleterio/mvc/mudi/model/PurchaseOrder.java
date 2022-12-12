package br.com.gustavoleterio.mvc.mudi.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PurchaseOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	private String name;
	private String description;
	private BigDecimal value;
	private LocalDate deliveryDate;
	private String url;
	private String imgUrl;
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	public PurchaseOrder() {
	}

	public PurchaseOrder(String name, String description, BigDecimal value, LocalDate deliveryDate, String url,
			String imgUrl) {
		this.name = name;
		this.description = description;
		this.value = value;
		this.deliveryDate = deliveryDate;
		this.url = url;
		this.imgUrl = imgUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFormatedValue() {
		if (value != null)
			return new DecimalFormat("#,##0.00").format(value);
		return null;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
