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
public class LoginController {

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
}
