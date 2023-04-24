package com.greatlearning.tta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.tta.entity.Tickets;

public interface TicketsRepository extends JpaRepository<Tickets, Long> {

	List<Tickets> findByTicketTitleContainingOrTicketShortDescriptionContainingAllIgnoreCase(String ticketTitle,
			String ticketShortDescription);

	List<Tickets> findByTicketTitleContainingAllIgnoreCase(String ticketTitle);

	List<Tickets> findByTicketShortDescriptionContainingAllIgnoreCase(String ticketShortDescription);

}
