package com.acorn.erp.domain.Customer.Controller;


import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public CustomerNotes saveNotes(@RequestBody CustomerNotes newNote){
    	 newNote.setNotesDate(Date.valueOf(LocalDate.now()));
         return repository.save(newNote);
    }
}
