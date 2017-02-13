package test;

import java.sql.SQLException;
import java.util.ArrayList;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO3 {
	public static void main(String[] args) {
		ProductDAO dao;
		try {
			dao = new ProductDAO();
			int highPrice = 150;
			int lowPrice = 120;
			ArrayList<ProductVO> list = dao.getProductListByPrice(lowPrice,highPrice);
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
