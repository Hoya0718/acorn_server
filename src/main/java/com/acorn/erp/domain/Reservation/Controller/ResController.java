package com.acorn.erp.domain.Reservation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Reservation.Service.ResService;
import com.acorn.erp.domain.Reservation.Entity.Reservation;

@CrossOrigin(origins = "http://localhost:3000") // 3000번 포트의 접근을 허락
@RestController
@RequestMapping("/api")
public class ResController {

    @Autowired
    private ResService resService;

    // 모든 예약정보 조회
    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        System.out.println("실행");
        return resService.getAllReservations();
    }

    // 특정 예약정보 조회
    @GetMapping("/reservations/{id}")
    public Reservation getReservation(@PathVariable("id") String id) {
        return resService.getReservation(id);
    }

    // 모든 예약정보 저장
    @PostMapping("/reservations")
    public String insertReservation(@RequestBody Reservation reservation) {
        resService.insertReservation(reservation);
        System.out.println("추가실행");
        return "Success";
    }
   
    // 특정 예약정보 삭제
    @DeleteMapping("/reservations/{id}")
    public String deleteReservation(@PathVariable("id") String id) {
        resService.deleteReservation(id);
        System.out.println("삭제실행");
        return "Success";
    }
   
    // 특정 예약정보 업데이트
    @PutMapping("/reservations/{id}")
    public String updateReservation(@RequestBody Reservation reservation) {
        resService.updateReservation(reservation);
        return "성공";
    }
   
    @GetMapping("/test")
    public String testDatabaseConnection() {
        try {
            List<Reservation> reservations = resService.getAllReservations();
            return "Successfully connected to the database. Number of reservations: " + reservations.size();
        } catch (Exception e) {
            return "Failed to connect to the database: " + e.getMessage();
        }
    }

}