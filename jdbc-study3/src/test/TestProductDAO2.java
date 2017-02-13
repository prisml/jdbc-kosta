package test;

import java.sql.SQLException;

import model.ProductDAO;
import model.ProductVO;

public class TestProductDAO2 {
	public static void main(String[] args) {
		ProductDAO dao;
		try {
			dao = new ProductDAO();
			ProductVO vo = new ProductVO("d", "������7", "����", 170);
			ProductVO pvo = dao.findProductById(vo.getId());
			if(pvo == null){
				dao.registerProduct(vo);
				System.out.println(vo + " insert ok");
			}else
				System.out.println(vo.getId() + " ���̵� �����ϹǷ� �߰� �Ұ�");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
