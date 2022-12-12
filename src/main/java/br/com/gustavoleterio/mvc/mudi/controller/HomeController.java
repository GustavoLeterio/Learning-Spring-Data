package br.com.gustavoleterio.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/home")
public class HomeController {

	@Autowired
	PurchaseOrderRepository repo;

	@GetMapping
	public String home(Model model) {
		List<PurchaseOrder> purchaseOrders = repo.findAll();
		model.addAttribute("purchaseOrders", purchaseOrders);
		return "home";
	}

	@GetMapping("/{status}")
	public String waiting(@PathVariable("status") String status, Model model) {
		List<PurchaseOrder> purchaseOrders = repo.findByStatus(OrderStatus.valueOf(status.toUpperCase()));
		model.addAttribute("purchaseOrders", purchaseOrders);
		return "/home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
