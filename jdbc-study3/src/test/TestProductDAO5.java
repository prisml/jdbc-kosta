package test;

import java.sql.SQLException;
import java.util.ArrayList;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO5 {
	public static void main(String[] args) {
		ProductDAO dao;
		try {
			dao = new ProductDAO();
			int percent=10;
			ArrayList<ProductVO> list = dao.getProductListDiscountPrice(percent);
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
