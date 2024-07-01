package com.acorn.erp.domain.Sales.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Sales.Entity.OrderTable;

@Repository
public interface OrderRepository extends JpaRepository<OrderTable, Long> {
	// customerId를 기준으로 존재 여부 확인
	boolean existsByCustomerId(@Param("customerId") int customerId);

	List<OrderTable> findByCustomerId(@Param("customerId") int customerId);
	
	@Query("SELECT o.customerName FROM OrderTable o WHERE o.customerId = :customerId ORDER BY o.orderDate DESC")
    List<String> findCustomerNameByCustomerId(@Param("customerId") int customerId);
	
	@Query("SELECT MAX(o.orderDate) FROM OrderTable o WHERE o.customerId = :customerId")
	LocalDateTime findTopByCustomerIdOrderByOrderDateDesc(@Param("customerId") int customerId);

	 @Query("SELECT SUM(o.orderTotalPrice) FROM OrderTable o WHERE o.customerId = :customerId")
	int sumOrderTotalPriceByCustomerId(@Param("customerId") int customerId);

	@Query("SELECT o.itemName FROM OrderTable o WHERE o.customerId = :customerId GROUP BY o.itemName ORDER BY SUM(o.itemQty) DESC")
	List<String> findFirstByCustomerIdOrderByTotalPriceDesc(@Param("customerId") int customerId);
	
	@Query("SELECT SUM(o.itemQty) FROM OrderTable o WHERE o.customerId = :customerId")
	int sumItemQtyByCustomerId(@Param("customerId") int customerId);

	@Query("SELECT o.itemName FROM OrderTable o WHERE o.customerId = :customerId GROUP BY o.itemName ORDER BY SUM(o.orderTotalPrice) DESC")
	List<String> findTopByCustomerIdOrderByItemQtyDesc(@Param("customerId") int customerId);

}

