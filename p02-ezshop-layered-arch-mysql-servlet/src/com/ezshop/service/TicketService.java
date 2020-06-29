package com.ezshop.service;


import java.util.List;

import com.ezshop.model.Ticket;
import com.ezshop.repository.TicketRepository;

public class TicketService {

	public Ticket getFirstRoundTicket() {
		
		Ticket ticket = null;
		TicketRepository ticketRepository = new TicketRepository();
		ticket = ticketRepository.getFirstRoundTicket();
		// the service layer applies the discount (business logic)
		ticket.setPrice(ticket.getPrice() - 50);
		return ticket;
	}

	public List<Ticket> getTickets() {
		TicketRepository ticketRepository = new TicketRepository();
		List<Ticket> tickets = ticketRepository.getTickets();
		return tickets;
		
		// return new ProductRepository().getProducts();
	}
	
		
		public boolean saveTicket(Ticket ticket) {
			TicketRepository ticketRepository = new TicketRepository();
			boolean saved = ticketRepository.saveTicket(ticket);
			// no logic in here
			// the service layer applies the discount (business logic)
//			product.setPrice(product.getPrice() - 50);
//			return ticket;
			return saved;
		}
		
		public boolean deleteTicket(int round) {
			TicketRepository ticketRepository = new TicketRepository();
			ticketRepository.deleteTicket(round);
			return false;
		}

	}

