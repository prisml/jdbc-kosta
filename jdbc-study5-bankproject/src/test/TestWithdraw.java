package test;

import dao.AccountDAO;
import model.AccountVO;

public class TestWithdraw {
	public static void main(String[] args) {
		try {
			AccountVO vo = new AccountVO("�ڿ���", "1234", 2000);
			AccountDAO dao = new AccountDAO();
			
			System.out.println("������ȸ");
			vo = dao.getAccount("�ڿ���","1234");
			dao.inquery(vo.getAccountNo(),"1234");
			
			System.out.println("���");
			dao.withdraw(vo.getAccountNo(),"1234",-5000000);
			dao.inquery(vo.getAccountNo(),"1234");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
