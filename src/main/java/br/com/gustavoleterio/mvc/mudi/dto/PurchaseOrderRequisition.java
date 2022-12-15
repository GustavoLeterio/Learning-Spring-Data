package br.com.gustavoleterio.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.gustavoleterio.mvc.mudi.model.Offer;
import br.com.gustavoleterio.mvc.mudi.model.OrderStatus;
import br.com.gustavoleterio.mvc.mudi.model.PurchaseOrder;

public class PurchaseOrderRequisition {
	@NotBlank
	private String name;
	@NotBlank
	private String url;
	@NotBlank
	private String imgUrl;
	private String description;

	public PurchaseOrderRequisition(String name, String url, String imgUrl, String description) {
		super();
		this.name = name;
		this.url = url;
		this.imgUrl = imgUrl;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PurchaseOrder toPurchaseOrder() {
		PurchaseOrder po = new PurchaseOrder();
		po.setName(name);
		po.setDescription(description);
		po.setUrl(url);
		po.setImgUrl(imgUrl);
		po.setStatus(OrderStatus.WAITING);
		return po;
	}

}
