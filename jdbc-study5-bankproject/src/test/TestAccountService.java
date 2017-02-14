package test;

import dao.AccountDAO;
import model.AccountVO;

public class TestAccountService {
	public static void main(String[] args) {
		try {
			AccountVO vo = new AccountVO("�ڿ���", "1234", 2000);
			AccountDAO dao = new AccountDAO();
			System.out.println("���»���");
			dao.createAccount(vo);
			
			System.out.println("������ȸ");
			vo = dao.getAccount("�ڿ���","1234");
			dao.inquery(vo.getAccountNo(),"1234");
			
			System.out.println("�Ա�");
			dao.deposit(vo.getAccountNo(),50000);
			dao.inquery(vo.getAccountNo(),"1234");
			
			System.out.println("���");
			dao.withdraw(vo.getAccountNo(),"1234",30000);
			dao.inquery(vo.getAccountNo(),"1234");
			
			System.out.println("���»���2");
			AccountVO vo2 = new AccountVO("�����", "1234", 3000);
			dao.createAccount(vo2);
			
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
