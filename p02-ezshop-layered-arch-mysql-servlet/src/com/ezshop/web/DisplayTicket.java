package com.ezshop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezshop.model.Ticket;
import com.ezshop.service.TicketService;;

@SuppressWarnings("serial")
@WebServlet("/DisplayTicket")
public class DisplayTicket extends HttpServlet {
	
	@Override
	// The service method
	// ACCEPTS REQUEST FROM THE BROWSER
	// PROCESSES THE REQUEST
	// SEND A RESPONSE
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// directly hitting the repository (not a good practice)
//		{
//			// Access the Repository to fetch the Products
//			ProductRepository productRepository = new ProductRepository();
//			Product product = productRepository.getFirstProduct();
//
//			// Generate the html output
//			PrintWriter printWriter = resp.getWriter();
//			printWriter.println("<!DOCTYPE html>");
//			printWriter.println("<html>");
//			printWriter.println("<head>");
//			printWriter.println("<title>Display First Product</title>");
//			printWriter.println("</head>");
//			printWriter.println("<body>");
//			printWriter.println("<h1>First Product : </h1>");
//			printWriter.println("<h3>" + product.getProductId() + "</h3>");
//			printWriter.println("<h3>" + product.getProductName() + "</h3>");
//			printWriter.println("<h3>" + product.getPrice() + "</h3>");
//			printWriter.println("<h3>" + product.getQuantity() + "</h3>");
//			printWriter.println("</body>");
//			printWriter.println("</html>");
//		}

		// a good practice using the service layer
		{
			// Access the Repository to fetch the Products
			System.out.println("NOW USING THE SERVICE LAYER!");
			TicketService ticketService = new TicketService();
			Ticket ticket = ticketService.getFirstRoundTicket();
			// Generate the html output
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("<!DOCTYPE html>");
			printWriter.println("<html>");
			printWriter.println("<head>");
			printWriter.println("<title>First Round</title>");
			printWriter.println("</head>");
			printWriter.println("<body>");
			printWriter.println("<h1>NBA Playoff First Round Ticket : </h1>");
			printWriter.println("<h3>" + ticket.getRound() + "</h3>");
			printWriter.println("<h3>" + ticket.getYourTeam() + "</h3>");
			printWriter.println("<h3>" + ticket.getPrice() + "</h3>");
			printWriter.println("<h3>" + ticket.getQuantity() + "</h3>");
			printWriter.println("</body>");
			printWriter.println("</html>");
		}
	}
}
