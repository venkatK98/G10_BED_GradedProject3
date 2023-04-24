package com.greatlearning.tta.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.tta.entity.Tickets;
import com.greatlearning.tta.service.TicketsService;

@Controller
public class TicketsController {

	private TicketsService ticketsService;

	public TicketsController(TicketsService ticketsService) {
		this.ticketsService = ticketsService;
	}

	@GetMapping("/tickets")
	public String listTickets(Model model) {
		model.addAttribute("tickets", ticketsService.getAllTickets());
		return "tickets";
	}

	@GetMapping("/tickets/new")
	public String createTicketsForm(Model model) {
		Tickets tickets = new Tickets();
		model.addAttribute("tickets", tickets);
		return "create_tickets";

	}

	@PostMapping("/tickets")
	public String saveTickets(@ModelAttribute("tickets") Tickets tickets) {
		ticketsService.saveTickets(tickets);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/edit/{id}")
	public String editTicketsForm(@PathVariable Long id, Model model) {
		model.addAttribute("tickets", ticketsService.getTicketsById(id));
		return "edit_tickets";
	}

	@PostMapping("/tickets/{id}")
	public String updateTickets(@PathVariable Long id, @ModelAttribute("tickets") Tickets tickets, Model model) {

		Tickets existingTickets = ticketsService.getTicketsById(id);
		existingTickets.setId(id);
		existingTickets.setTicketTitle(tickets.getTicketTitle());
		existingTickets.setTicketShortDescription(tickets.getTicketShortDescription());
		existingTickets.setTicketCreatedOn(tickets.getTicketCreatedOn());
		existingTickets.setTicketContent(tickets.getTicketContent());

		ticketsService.updateTickets(existingTickets);
		return "redirect:/tickets";

	}

	@GetMapping("/tickets/{id}")
	public String deleteTickets(@PathVariable Long id) {
		ticketsService.deleteTicketsById(id);
		return "redirect:/tickets";
	}

	@GetMapping("/tickets/view/{id}")
	public String viewTicketsForm(@PathVariable Long id, Model model) {
		model.addAttribute("tickets", ticketsService.getTicketsById(id));
		return "view_tickets";
	}

	@GetMapping("/tickets/search")
	public String search(@RequestParam("q") String query, Model model) {
		if (query == null || query.trim().isEmpty()) {
			return "redirect:/tickets";
		} else {
			List<Tickets> tickets = ticketsService.searchBy(query);
			model.addAttribute("tickets", tickets);
			return "tickets";
		}
	}

}
