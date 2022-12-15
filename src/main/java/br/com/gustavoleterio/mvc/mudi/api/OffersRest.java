package br.com.gustavoleterio.mvc.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoleterio.mvc.mudi.dto.OfferRequisition;
import br.com.gustavoleterio.mvc.mudi.model.Offer;
import br.com.gustavoleterio.mvc.mudi.model.PurchaseOrder;
import br.com.gustavoleterio.mvc.mudi.repository.PurchaseOrderRepository;

@RestController
@RequestMapping("/api/offers")
public class OffersRest {

	@Autowired
	private PurchaseOrderRepository poRepo;
	
	@PostMapping
	public Offer createOffer(@Valid @RequestBody OfferRequisition req) {
		Optional<PurchaseOrder> poOptional = poRepo.findById(req.getId());
		if(!poOptional.isPresent()) {
			return null;
		}
		PurchaseOrder po = poOptional.get();
		
		Offer offer = req.toOffer();
		offer.setPurchaseOrder(po);
		po.getOffers().add(offer);
		
		poRepo.save(po);
		
		return offer;
	}
}
