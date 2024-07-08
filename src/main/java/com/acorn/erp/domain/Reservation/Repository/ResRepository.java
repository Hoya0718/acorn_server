
package com.acorn.erp.domain.Reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Reservation.Entity.Reservation;

@Repository
public interface ResRepository extends JpaRepository<Reservation, Long> {
}
