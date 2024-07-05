package com.acorn.erp.domain.Customer.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Customer.Entity.CustomerNotes;

@Repository
public interface NotesRepository extends JpaRepository<CustomerNotes, Integer> {
	
}