package com.example.crud.controller;

import com.example.crud.model.Ticket;
import com.example.crud.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TicketController {

    @Autowired
    private TicketRepository repository;

    @PostMapping("/add")
    public String addTicket(@RequestBody List<Ticket> tickets){
        repository.saveAll(tickets);
        return "*--The number of ticket is :"+tickets.size();
    }

    @PutMapping("/change")
    public String editTicket(@RequestBody Ticket tickets){
        repository.save(tickets);
        return "*--Successfully edited :"+tickets.getId();
    }

    @GetMapping("/get")
    public List<Ticket> getTickets(){
        List<Ticket> tickets = repository.findAll();
        return  tickets;
    }

    @DeleteMapping("/del/{id}")
    public String deleteTicket(@PathVariable("id") int id){
       Optional<Ticket> ticket = repository.findById(id);
       repository.deleteById(id);
        return "Successfully deleted :"+ ticket.get().getId();
    }



}
