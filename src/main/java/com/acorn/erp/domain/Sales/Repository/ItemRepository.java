//package com.acorn.erp.domain.Sales.Repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.acorn.erp.domain.Sales.Entity.Item;
//
//@Repository
//public interface ItemRepository extends JpaRepository<Item, Long> {
//    @Query("SELECT i FROM Item i WHERE i.itemCode = :itemCode")
//    Item findByItemCode(@Param("itemCode") Long itemCode);
//}
