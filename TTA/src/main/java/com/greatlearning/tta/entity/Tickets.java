package com.greatlearning.tta.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tickets")
public class Tickets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ticket_title", nullable = false)
	private String ticketTitle;

	@Column(name = "ticket_short_description")
	private String ticketShortDescription;

	@Column(name = "ticket_created_on")
	private String ticketCreatedOn;

	@Column(name = "ticket_content")
	private String ticketContent;

	public Tickets() {

	}

	public Tickets(String ticketTitle, String ticketShortDescription, String ticketCreatedOn, String ticketContent) {
		this.ticketTitle = ticketTitle;
		this.ticketShortDescription = ticketShortDescription;
		this.ticketCreatedOn = ticketCreatedOn;
		this.ticketContent = ticketContent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicketTitle() {
		return ticketTitle;
	}

	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}

	public String getTicketShortDescription() {
		return ticketShortDescription;
	}

	public void setTicketShortDescription(String ticketShortDescription) {
		this.ticketShortDescription = ticketShortDescription;
	}

	public String getTicketCreatedOn() {
		return ticketCreatedOn;
	}

	public void setTicketCreatedOn(String ticketCreatedOn) {
		this.ticketCreatedOn = ticketCreatedOn;
	}

	public String getTicketContent() {
		return ticketContent;
	}

	public void setTicketContent(String ticketContent) {
		this.ticketContent = ticketContent;
	}

}
