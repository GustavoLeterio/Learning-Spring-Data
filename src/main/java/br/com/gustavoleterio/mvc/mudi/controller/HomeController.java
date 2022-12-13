package br.com.gustavoleterio.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gustavoleterio.mvc.mudi.model.OrderStatus;
import br.com.gustavoleterio.mvc.mudi.model.PurchaseOrder;
import br.com.gustavoleterio.mvc.mudi.repository.PurchaseOrderRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	PurchaseOrderRepository repo;

	Sort sortByDeliveredDate = Sort.by("deliveryDate").descending();

	@GetMapping
	public String home(Model model, Principal principal) {
		PageRequest page = PageRequest.of(0, 10, sortByDeliveredDate);	
		List<PurchaseOrder> purchaseOrders = repo.findByStatus(OrderStatus.DELIVERED, page);
		model.addAttribute("purchaseOrders", purchaseOrders);
		return "home";
	}
}
