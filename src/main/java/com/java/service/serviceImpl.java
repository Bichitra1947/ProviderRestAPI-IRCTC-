package com.java.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.binding.Passenger;
import com.java.entity.Ticket;
import com.java.repository.TicketRepository;

@Service
public class serviceImpl implements TicketService {

	@Autowired
	private TicketRepository repository;
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		Ticket ticket=new Ticket();
		ticket.setPrice(4500.00);
		ticket.setTarinNo(34532);
		ticket.setStatus("Confirmed");
		BeanUtils.copyProperties(passenger, ticket);
		
		repository.save(ticket);
		return ticket;
	}
	
	@Override
	public Ticket getTicket(Integer ticketNo) {

		Optional<Ticket> optional = repository.findById(ticketNo);
		if(optional.isEmpty()) {
			System.out.println("Empty ticket");
		}
		Ticket ticket = optional.get();
		return ticket;
		
	}

	@Override
	public List<Ticket> getAllTicket() {
		List<Ticket> allTicket = repository.findAll();
		return allTicket;
	}

}
