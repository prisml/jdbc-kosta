package test;

import java.sql.SQLException;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO1 {
	public static void main(String[] args) {
		ProductDAO dao;
		try {
			dao = new ProductDAO();
			ProductVO pvo = dao.findProductById("a");
			System.out.println(pvo);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
