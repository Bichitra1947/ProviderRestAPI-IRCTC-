package com.java.service;

import java.util.List;

import com.java.binding.Passenger;
import com.java.entity.Ticket;

public interface TicketService {

	public Ticket bookTicket(Passenger passenger);
	public Ticket getTicket(Integer ticketNo);
	public List<Ticket> getAllTicket();
}
