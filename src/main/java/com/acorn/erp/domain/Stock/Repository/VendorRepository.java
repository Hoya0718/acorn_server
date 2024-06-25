package com.acorn.erp.domain.Stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Stock.Entity.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
