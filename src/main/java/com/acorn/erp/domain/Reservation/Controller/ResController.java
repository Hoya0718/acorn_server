package com.acorn.erp.domain.Reservation.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.acorn.erp.domain.Reservation.Entity.Reservation;
import com.acorn.erp.domain.Reservation.Service.ResService;

@RestController
@RequestMapping("/api")
public class ResController {

    @Autowired
    private ResService resService;

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() {
        return resService.getAllReservations(); 
    }

    @GetMapping("/reservations/{id}")
    public Reservation getReservation(@PathVariable("id") Long id) {
        return resService.getReservation(id);
    }

    @PostMapping("/reservations")
    public ResponseEntity<String> insertReservation(@RequestBody Reservation reservation) {
        System.out.println("Received reservation: " + reservation);
        resService.insertReservation(reservation);
        return ResponseEntity.ok().body("Reservation created successfully");
    }

    @PutMapping("/reservations/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable("id") Long id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        resService.updateReservation(reservation);
        return ResponseEntity.ok().body("Reservation updated successfully.");
    }

    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable("id") Long id) {
        resService.deleteReservation(id);
        return ResponseEntity.ok().body("Reservation deleted successfully.");
    }
    
}