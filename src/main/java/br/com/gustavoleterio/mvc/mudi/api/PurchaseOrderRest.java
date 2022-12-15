package br.com.gustavoleterio.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoleterio.mvc.mudi.model.OrderStatus;
import br.com.gustavoleterio.mvc.mudi.model.PurchaseOrder;
import br.com.gustavoleterio.mvc.mudi.repository.PurchaseOrderRepository;

@RestController
@RequestMapping("/api/orders")
public class PurchaseOrderRest {

	@Autowired
	private PurchaseOrderRepository poRepo;

	private Sort sortByDeliveryDate = Sort.by("deliveryDate").descending();
	private PageRequest pagePattern;

	@GetMapping("{status}")
	public List<PurchaseOrder> getPurchaseOrdersByStatus(@PathVariable("status") String status) {
		return poRepo.findByStatus(OrderStatus.valueOf(status.toUpperCase()), pagePattern);
	}
}
