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

@CrossOrigin(origins = "http://localhost:3000") // 3000번 포트의 접근은 허락한다.
@RestController
@RequestMapping("/api")
public class ResController {

    @Autowired
    private ResService resService;

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        System.out.println("실행");
        return resService.getAllReservations();
    }

    @GetMapping("/reservations/{id}")
    public Reservation getReservation(@PathVariable("id") int id) {
        return resService.getReservation(id);
    }

    @PostMapping("/reservations")
    public String insertReservation(@RequestBody Reservation reservation) {
        resService.insertReservation(reservation);
        System.out.println("추가실행");
        return "Success";
    }

    @DeleteMapping("/reservations/{id}")
    public String deleteReservation(@PathVariable("id") int id) {
        resService.deleteReservation(id);
        System.out.println("삭제실행");
        return "Success";
    }

    @PutMapping("/reservations/{id}")
    public String updateReservation(@RequestBody Reservation reservation) {
        resService.updateReservation(reservation);
        return "성공";
    }
}
