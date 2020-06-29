package com.ezshop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezshop.model.Ticket;
import com.ezshop.service.TicketService;

@SuppressWarnings("serial")
@WebServlet("/DisplayTickets")
public class DisplayTickets extends HttpServlet {

	@Override
	// The service method
	// ACCEPTS REQUEST FROM THE BROWSER
	// PROCESS THE REQUEST
	// SEND A RESPONSE
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// directly hitting the repository ( not a good practice )
		// {
		// // Access the Repository to fetch the Products
		// ProductRepository productRepository = new ProductRepository();
		// Product product = productRepository.getFirstProduct();
		//
		// // Generate the html output
		// PrintWriter printWriter = resp.getWriter();
		// printWriter.println("<!DOCTYPE html>");
		// printWriter.println("<html>");
		// printWriter.println("<head>");
		// printWriter.println("<title>Display First Product</title>");
		// printWriter.println("</head>");
		// printWriter.println("<body>");
		// printWriter.println("<h1>First Product : </h1>");
		// printWriter.println("<h4>" + product.getProductId() + "</h4>");
		// printWriter.println("<h4>" + product.getProductName() + "</h4>");
		// printWriter.println("<h4>" + product.getPrice() + "</h4>");
		// printWriter.println("<h4>" + product.getQuantity() + "</h4>");
		// printWriter.println("</body>");
		// printWriter.println("</html>");
	// }

		// a good practice using the service layer
		{

			// Access the Repository to fetch the Products
			System.out.println("NOW USING THE SERVICE LAYER");
			TicketService ticketService = new TicketService();
			List<Ticket> tickets = ticketService.getTickets();
			// Generate the html output
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("<!DOCTYPE html>");
			printWriter.println("<html>");
			printWriter.println("<head>");
			printWriter.println("<title>All Tickets</title>");
			printWriter.println("</head>");
			printWriter.println("<body>");
			printWriter.println("<h1>First Round : </h1>");
			for (Ticket ticket : tickets) {
				printWriter.println("<h4>" + ticket.getRound() + "</h4>");
				printWriter.println("<h4>" + ticket.getYourTeam() + "</h4>");
				printWriter.println("<h4>" + ticket.getPrice() + "</h4>");
				printWriter.println("<h4>" + ticket.getQuantity() + "<h4/>");
				printWriter.println("<hr/>");
			}
			printWriter.println("</body>");
			printWriter.println("</html>");
		}
	}

}