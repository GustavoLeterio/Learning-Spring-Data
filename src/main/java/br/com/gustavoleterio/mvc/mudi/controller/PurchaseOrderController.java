package br.com.gustavoleterio.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gustavoleterio.mvc.mudi.dto.PurchaseOrderRequisition;
import br.com.gustavoleterio.mvc.mudi.model.PurchaseOrder;
import br.com.gustavoleterio.mvc.mudi.repository.PurchaseOrderRepository;
import br.com.gustavoleterio.mvc.mudi.repository.UserRepository;

@Controller
@RequestMapping(value = "order", method = RequestMethod.POST)
public class PurchaseOrderController {

	@Autowired
	private PurchaseOrderRepository poRepo;
	
	@Autowired
	private UserRepository userRepo;

	@GetMapping("form")
	public String form(PurchaseOrderRequisition req) {
		return "order/form";
	}

	@GetMapping("register")
	public String register(@Valid PurchaseOrderRequisition req, BindingResult res) {
		if (res.hasErrors())
			return "order/form";
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		PurchaseOrder po = req.toPurchaseOrder();
		po.setUser(userRepo.findByUsername(username));
		poRepo.save(po);
		return "redirect:/user/orders";
	}
}
