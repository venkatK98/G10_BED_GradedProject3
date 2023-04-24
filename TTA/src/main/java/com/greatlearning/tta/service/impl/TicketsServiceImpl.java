package com.greatlearning.tta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.tta.entity.Tickets;
import com.greatlearning.tta.repository.TicketsRepository;
import com.greatlearning.tta.service.TicketsService;

@Service
public class TicketsServiceImpl implements TicketsService {

	@Autowired
	private TicketsRepository ticketsRepository;

	@Override
	public List<Tickets> getAllTickets() {
		return ticketsRepository.findAll();
	}

	@Override
	public Tickets saveTickets(Tickets tickets) {
		return ticketsRepository.save(tickets);
	}

	@Override
	public Tickets getTicketsById(Long id) {
		return ticketsRepository.findById(id).get();
	}

	@Override
	public Tickets updateTickets(Tickets tickets) {
		return ticketsRepository.save(tickets);
	}

	@Override
	public void deleteTicketsById(Long id) {
		ticketsRepository.deleteById(id);

	}

	public List<Tickets> searchBy(String query) {
		return ticketsRepository.findByTicketTitleContainingOrTicketShortDescriptionContainingAllIgnoreCase(query,
				query);
	}

}
