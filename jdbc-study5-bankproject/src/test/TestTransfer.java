package test;

import dao.AccountDAO;
import model.AccountVO;

public class TestTransfer {
	public static void main(String[] args) {
		try {
			AccountVO vo = new AccountVO("�ڿ���", "1234", 2000);
			AccountDAO dao = new AccountDAO();
		
			System.out.println("������ȸ");
			vo = dao.getAccount("�ڿ���","1234");
			dao.inquery(vo.getAccountNo(),"1234");
			
			AccountVO vo2 = new AccountVO("�����", "1234", 3000);
			System.out.println("������ȸ");
			vo2 = dao.getAccount("�����","1234");
			dao.inquery(vo2.getAccountNo(),"1234");
			
			System.out.println("������ü");
			dao.transfer(vo.getAccountNo(),"1234",vo2.getAccountNo(),5000);
			dao.inquery(vo.getAccountNo(),"1234");
			dao.inquery(vo2.getAccountNo(),"1234");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
