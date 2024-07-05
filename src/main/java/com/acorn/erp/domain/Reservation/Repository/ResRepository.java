package com.acorn.erp.domain.Reservation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acorn.erp.domain.Reservation.Entity.Reservation;

@Repository
public interface ResRepository extends JpaRepository<Reservation, Long> {
	@Query(value="select * from reservation r where r.id=?1 order by  desc", nativeQuery=true)
    Reservation findReservation1(Long id);
}
