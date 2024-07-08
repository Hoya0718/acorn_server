package com.acorn.erp.domain.Customer.Controller;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acorn.erp.domain.Customer.Entity.CustomerNotes;
import com.acorn.erp.domain.Customer.Repository.NotesRepository;

@RestController
@RequestMapping("/api/customer")
public class NotesController {

    @Autowired
    private NotesRepository repository;
    
    @GetMapping("/getNotes")
    public List<CustomerNotes> getAllNotes(){
    	List<CustomerNotes> notes = repository.findAll();
    	notes.sort(Comparator.comparing(CustomerNotes::getNotesId).reversed());
        return notes;
    }
    @PostMapping("/saveNotes")
    public ResponseEntity<?> saveNotes(@RequestBody CustomerNotes newNote){
//    	if (newNote.getCustomerId() == 0 || newNote.getNotes() == null || newNote.getNotes().isEmpty()) {
//            return ResponseEntity.badRequest().body("Customer ID or Notes cannot be null or empty");
//        }
//    	
    	CustomerNotes customerNotes= new CustomerNotes();
    	customerNotes.setCustomerId(newNote.getCustomerId());
    	customerNotes.setNotes(newNote.getNotes());
    	customerNotes.setNotesDate(Date.valueOf(LocalDate.now()));
    	 CustomerNotes savedNote = repository.save(customerNotes);
         return ResponseEntity.ok(savedNote);
    }
    @DeleteMapping("/notes/{notesId}")
    public ResponseEntity<?> deleteNotes(@PathVariable("notesId")  Integer notesId){
    	System.out.println("Received notesId: " + notesId);
    	if (notesId == null) {
            return ResponseEntity.badRequest().body("Notes ID cannot be null");
        }

        if (!repository.existsById(notesId)) {
            return ResponseEntity.badRequest().body("Notes ID does not exist");
        }

        repository.deleteById(notesId);
        return ResponseEntity.ok("Notes deleted successfully");
    }
}
