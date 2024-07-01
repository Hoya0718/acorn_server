package com.acorn.erp.domain.Reservation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.erp.domain.Reservation.Entity.Reservation;
import com.acorn.erp.domain.Reservation.Repository.ResMapper;

@Service
public class ResService {

    @Autowired
    private ResMapper resMapper;

    public List<Reservation> getAllReservations() {
        return resMapper.getAllReservations();
    }

    public Reservation getReservation(int id) {
        return resMapper.getReservation(id);
    }

    public void insertReservation(Reservation reservation) {
        resMapper.insertReservation(reservation);
    }

    public void deleteReservation(int id) {
        resMapper.deleteReservation(id);
    }

    public void updateReservation(Reservation reservation) {
        resMapper.updateReservation(reservation);
        System.out.println("서비스 성공");
    }
}
