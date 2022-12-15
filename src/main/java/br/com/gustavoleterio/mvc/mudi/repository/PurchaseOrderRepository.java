package br.com.gustavoleterio.mvc.mudi.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.gustavoleterio.mvc.mudi.model.OrderStatus;
import br.com.gustavoleterio.mvc.mudi.model.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
	// Extending JpaRepository, we have a bunch of methods, as findAll and findById
	
	List<PurchaseOrder> findByStatus(OrderStatus status, Pageable pageable);

	@Cacheable("ordersByUsers")
	@Query("select po from PurchaseOrder po where po.user.username = :username")
	List<PurchaseOrder> findByUser(@Param("username") String username, Pageable page);

	@Cacheable("ordersByStatusAndUsers")
	@Query("select po from PurchaseOrder po where po.user.username = :username and po.status = :status")
	List<PurchaseOrder> findByStatusAndUser(@Param("username") String username, @Param("status") OrderStatus status,
			Pageable page);
}
