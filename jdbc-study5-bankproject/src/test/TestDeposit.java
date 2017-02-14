package test;

import dao.AccountDAO;
import model.AccountVO;

public class TestDeposit {
	public static void main(String[] args) {
		AccountVO vo = null;
		AccountDAO dao = null;
		try {
			vo = new AccountVO("�ڿ���", "1234", 2000);
			dao = new AccountDAO();

			System.out.println("������ȸ");
			vo = dao.getAccount("�ڿ���", "1234");
			dao.inquery(vo.getAccountNo(), "1234");

			System.out.println("�Ա�");
			dao.deposit(vo.getAccountNo(), 500);
			dao.inquery(vo.getAccountNo(), "1234");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("�Ա�");
		try {
			dao.deposit(vo.getAccountNo(), -500000);
			dao.inquery(vo.getAccountNo(), "1234");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
