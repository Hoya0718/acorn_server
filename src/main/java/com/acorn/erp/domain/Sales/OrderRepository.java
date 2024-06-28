package com.acorn.erp.domain.Sales;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<OrderTable, Integer> {
	// customerId를 기준으로 존재 여부 확인
	boolean existsByCustomerId(@Param("customerId") int customerId);

	List<OrderTable> findByCustomerId(@Param("customerId") int customerId);
	
	@Query("SELECT o.customerName FROM OrderTable o WHERE o.customerId = :customerId ORDER BY o.orderDate DESC")
    List<String> findCustomerNameByCustomerId(@Param("customerId") int customerId);
	
	@Query("SELECT MAX(o.orderDate) FROM OrderTable o WHERE o.customerId = :customerId")
	Date findTopByCustomerIdOrderByOrderDateDesc(@Param("customerId") int customerId);

	 @Query("SELECT SUM(o.totalPrice) FROM OrderTable o WHERE o.customerId = :customerId")
	int sumTotalPriceByCustomerId(@Param("customerId") int customerId);

	@Query("SELECT o.itemName FROM OrderTable o WHERE o.customerId = :customerId GROUP BY o.itemName ORDER BY SUM(o.itemQty) DESC")
	List<String> findFirstByCustomerIdOrderByTotalPriceDesc(@Param("customerId") int customerId);
	
	@Query("SELECT SUM(o.itemQty) FROM OrderTable o WHERE o.customerId = :customerId")
	int sumItemQtyByCustomerId(@Param("customerId") int customerId);

	@Query("SELECT o.itemName FROM OrderTable o WHERE o.customerId = :customerId GROUP BY o.itemName ORDER BY SUM(o.totalPrice) DESC")
	List<String> findTopByCustomerIdOrderByItemQtyDesc(@Param("customerId") int customerId);
}
