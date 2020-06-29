package com.ezshop.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezshop.service.TicketService;

@SuppressWarnings("serial")
@WebServlet("/DeleteTicket")
public class DeleteTicket extends HttpServlet {

	@Override
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String round = request.getParameter("round");
//		String yourTeam = request.getParameter("yourTeam");
		TicketService ticketService = new TicketService();
		boolean deleted = ticketService.deleteTicket(Integer.parseInt(round)); // convert to an int
		if (deleted) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("deleted-ticket.html");
			requestDispatcher.forward(request, response);
		}
	}
}
