package com.acorn.erp.domain.Customer.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Customer.Entity.CustomerNotes;

@Repository
public interface NotesRepository extends JpaRepository<CustomerNotes, Integer> {
	Optional<CustomerNotes> findByCustomerIdAndNotes(int customerId, String notes);
	 boolean existsById(int notesId);
}