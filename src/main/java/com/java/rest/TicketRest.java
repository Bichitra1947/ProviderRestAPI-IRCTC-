package com.java.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.binding.Passenger;
import com.java.entity.Ticket;
import com.java.service.TicketService;

@RestController
public class TicketRest {
	@Autowired
	private TicketService service;
	ResponseEntity<Ticket> responseEntity;
	
	@PostMapping("/bookTicket")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger) {
		Ticket ticket = service.bookTicket(passenger);
		responseEntity = new ResponseEntity<>(ticket,HttpStatus.CREATED);
		return responseEntity ;
		
	}
	
	@GetMapping("/getTicket/{ticketNo}")
	public ResponseEntity<Ticket> getTicket(@PathVariable Integer ticketNo ) {
		Ticket ticket = service.getTicket(ticketNo);
		return responseEntity = new ResponseEntity<>(ticket,HttpStatus.CREATED);
	}
	
	@GetMapping("/tickets")
	public List<Ticket> getAllTicket(){
		List<Ticket> allTicket = service.getAllTicket();
		return allTicket;
	}

}
