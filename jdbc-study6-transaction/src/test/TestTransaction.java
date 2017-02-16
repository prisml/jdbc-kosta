package test;

import java.sql.SQLException;

import model.CardDAO;

public class TestTransaction {
	public static void main(String[] args) {
		CardDAO dao;
		try {
			dao = new CardDAO();
			dao.registerCard("tomcat","°­Á¤È£",1000);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
