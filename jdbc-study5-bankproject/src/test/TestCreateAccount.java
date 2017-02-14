package test;

import dao.AccountDAO;
import model.AccountVO;

public class TestCreateAccount {
	public static void main(String[] args) {
		AccountDAO dao = null;
		AccountVO vo = null;
		try {
			dao = new AccountDAO();
			vo = new AccountVO("�̽¿�", "2480", 2000);
			System.out.println("���»���");
			dao.createAccount(vo);

			System.out.println("������ȸ");
			vo = dao.getAccount("�̽¿�", "2480");
			dao.inquery(vo.getAccountNo(), "2480");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.inquery(vo.getAccountNo()+100, "2480");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // ���� ����
		
		try {
			dao.inquery(vo.getAccountNo(), "0234");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // �н����� ����ġ
		
		AccountVO vo2 = null;
		try {
			vo2 = new AccountVO("������", "1357", 999);
			System.out.println("���»���");
			dao.createAccount(vo2); // �����Ұ�

			System.out.println("������ȸ");
			vo2 = dao.getAccount("�����", "1357");
			dao.inquery(vo.getAccountNo(), "1357");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
