package com.ezshop.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import com.ezshop.model.Ticket;

public class TicketRepository {
	public Ticket getFirstRoundTicket() {
		try {
			// ticket fetch from db
			Ticket ticket = new Ticket();
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/NBA_Playoffs?serverTimezone="+TimeZone.getDefault().getID(), "root", "password");
			System.out.println("Connection Established!");
			
			// create the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			ResultSet resultSet = statement.executeQuery("select * from teams");
			// Iterate the resultSet
			if (resultSet.next()) {
				ticket.setRound(resultSet.getInt(("playoff_round")));
				ticket.setYourTeam(resultSet.getString("name"));
				ticket.setPrice(resultSet.getFloat("price"));
				ticket.setQuantity(resultSet.getInt("quantity"));
			}
			resultSet.close();
			statement.close();
			return ticket;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return null;
	}
	
	@SuppressWarnings( "unchecked" )
	public List<Ticket> getTickets() {
		try {
			// tickets fetch from db
			List ticketList = new ArrayList<Ticket>();
			Ticket ticket = null;
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/NBA_Playoffs?serverTimezone="+TimeZone.getDefault().getID(), "root", "password");
			System.out.println("Connection Established!");
		
			// create the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing query
			ResultSet resultSet = statement.executeQuery("select * from teams");
			// Iterate the resultSet
			while (resultSet.next()) {
				ticket = new Ticket();
				ticket.setRound(resultSet.getInt(("playoff_round")));
				ticket.setYourTeam(resultSet.getString("name"));
				ticket.setPrice(resultSet.getFloat("price"));
				ticket.setQuantity(resultSet.getInt("quantity"));
				ticketList.add(ticket);
			}
			resultSet.close();
			statement.close();
			connection.close();
			System.out.println(ticketList);
			return ticketList;
	} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
	}
	return null;	
}

	public boolean saveTicket(Ticket ticket) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/NBA_Playoffs?serverTimezone="+TimeZone.getDefault().getID(), "root", "password");
			System.out.println("Connection Established!");

			// create the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			String insertQuery = "insert into teams values ('" + ticket.getRound() + "','"
					+ ticket.getYourTeam() + "'," + ticket.getPrice() + "," + ticket.getQuantity() + ")";
			System.out.println(insertQuery);
			statement.executeUpdate(insertQuery);
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return false;
	}

	public boolean deleteTicket(int round) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/NBA_Playoffs?serverTimezone="+TimeZone.getDefault().getID(), "root", "password");
			System.out.println("Connection Established!");

			// create the statement
			Statement statement = connection.createStatement();
			System.out.println("Statement created!");
			// Fetch the results by executing the query
			String deleteQuery = "delete from teams where product_id = '" + round + "'";
			System.out.println(deleteQuery);
			statement.executeUpdate(deleteQuery);
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return false;
		
	}
}
