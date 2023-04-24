package com.greatlearning.tta.service;

import java.util.List;

import com.greatlearning.tta.entity.Tickets;

public interface TicketsService {

	List<Tickets> getAllTickets();

	Tickets saveTickets(Tickets tickets);

	Tickets getTicketsById(Long id);

	Tickets updateTickets(Tickets tickets);

	void deleteTicketsById(Long id);

	public List<Tickets> searchBy(String query);

}
