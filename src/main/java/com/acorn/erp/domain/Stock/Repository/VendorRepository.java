package com.acorn.erp.domain.Stock.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Stock.Entity.Vendor;


@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
	// 거래처 코드로 검색
	Page<Vendor> findByVendorCode(Long vendorCode,  Pageable pageable);

	// 거래처명으로 검색
	List<Vendor> findByVendorNameContainingIgnoreCase(String keyword);
	

}