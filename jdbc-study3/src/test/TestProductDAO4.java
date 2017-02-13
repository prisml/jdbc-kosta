package test;

import java.sql.SQLException;
import java.util.ArrayList;

import model.ProductDAO;

public class TestProductDAO4 {
	public static void main(String[] args) {
		ProductDAO dao;
		try {
			dao = new ProductDAO();
			ArrayList<String> list = dao.getProductMakerKind();
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
