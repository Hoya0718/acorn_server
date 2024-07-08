
package com.acorn.erp.domain.Reservation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Reservation.Entity.Reservation;
import com.acorn.erp.domain.Reservation.Repository.ResRepository;

import jakarta.transaction.Transactional;

@Service
public class ResService {

    @Autowired
    private ResRepository resRepository;

    @Transactional
    public List<Reservation> getAllReservations() {
        return resRepository.findAll();
    }
    @Transactional
    public Reservation getReservation(Long id) {
        return resRepository.findById(id).orElse(null);
    }
    @Transactional
    public Reservation insertReservation(Reservation reservation) {
    	System.out.println("Inserting reservation: " + reservation);
        return resRepository.save(reservation);
    }
    @Transactional
    public void deleteReservation(Long id) {
        resRepository.deleteById(id);
    }
    @Transactional
    public void updateReservation(Reservation reservation) {
        resRepository.save(reservation);
        System.out.println("서비스 성공");
    }
    
    @Transactional
    public Reservation saveReservation(Reservation reservation) {
        // 로그 추가
        System.out.println("Saving reservation: " + reservation);
        return resRepository.save(reservation);
    }
}
