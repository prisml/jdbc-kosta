package test;

import java.sql.SQLException;

import model.CardDAO2;

public class TestTransaction2 {
	public static void main(String[] args) {
		CardDAO2 dao;
		try {
			dao = new CardDAO2();
			dao.registerCard("tomcat","°­Á¤È£",1000);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
