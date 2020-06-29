package com.ezshop.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezshop.model.Ticket;
import com.ezshop.service.TicketService;

@SuppressWarnings("serial")
@WebServlet("/AddTicket")
public class AddTicket extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String round = request.getParameter("round");
		String yourTeam = request.getParameter("yourTeam");
		float price = Float.parseFloat(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(round);
		System.out.println(yourTeam);
		System.out.println(price);
		System.out.println(quantity);
		
		// send the tickets to the service layer
		Ticket ticket = new Ticket();
		ticket.setRound(Integer.valueOf(round)); // converted from a string to int 
		ticket.setYourTeam(yourTeam);
		ticket.setPrice(price);
		ticket.setQuantity(quantity);
		
		TicketService ticketService = new TicketService();
		boolean saved = ticketService.saveTicket(ticket);
		if (saved) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("added-ticket.html");
			requestDispatcher.forward(request, response);
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("add-product-failed.html");
			requestDispatcher.forward(request, response);
		}
	
		// resp.sendRedirect("added-product.jsp");
	}

}
