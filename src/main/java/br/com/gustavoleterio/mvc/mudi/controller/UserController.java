package br.com.gustavoleterio.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gustavoleterio.mvc.mudi.model.OrderStatus;
import br.com.gustavoleterio.mvc.mudi.model.PurchaseOrder;
import br.com.gustavoleterio.mvc.mudi.repository.PurchaseOrderRepository;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	PurchaseOrderRepository repo;
	
	Sort sortByDeliveryDate = Sort.by("deliveryDate").descending();
	PageRequest pagePattern = PageRequest.of(0, 10, sortByDeliveryDate);

	@GetMapping("/orders")
	public String home(Model model, Principal principal) {
		List<PurchaseOrder> purchaseOrders = repo.findByUser(
					principal.getName(), 
					pagePattern
				);
		
		model.addAttribute("purchaseOrders", purchaseOrders);
		return "/user/orders";
	}

	@GetMapping("/{status}")
	public String byStatus(@PathVariable("status") String status, Model model, Principal principal) {
		List<PurchaseOrder> purchaseOrders = repo.findByStatusAndUser(
					principal.getName(),
					OrderStatus.valueOf(status.toUpperCase()),
					pagePattern
				);
		
		model.addAttribute("purchaseOrders", purchaseOrders);
		return "/user/orders";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/user/home";
	}
}
