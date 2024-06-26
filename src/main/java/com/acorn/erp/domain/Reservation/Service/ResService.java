package com.acorn.erp.domain.Reservation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Reservation.Repository.ResRepository;
import com.acorn.erp.domain.Reservation.Entity.Reservation;

@Service
public class ResService {

    @Autowired
    private ResRepository resRepository;

    public List<Reservation> getAllReservations() {
        return resRepository.getAllReservations();
    }

    public Reservation getReservation(String id) {
        return resRepository.getReservation(id);
    }

    public void insertReservation(Reservation reservation) {
        resRepository.insertReservation(reservation);
    }

    public void deleteReservation(String id) {
        resRepository.deleteReservation(id);
    }

    public void updateReservation(Reservation reservation) {
        resRepository.updateReservation(reservation);
        System.out.println("서비스 성공");
    }
}