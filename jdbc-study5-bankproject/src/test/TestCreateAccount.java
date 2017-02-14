package test;

import dao.AccountDAO;
import model.AccountVO;

public class TestCreateAccount {
	public static void main(String[] args) {
		AccountDAO dao = null;
		AccountVO vo = null;
		try {
			dao = new AccountDAO();
			vo = new AccountVO("이승우", "2480", 2000);
			System.out.println("계좌생성");
			dao.createAccount(vo);

			System.out.println("계좌조회");
			vo = dao.getAccount("이승우", "2480");
			dao.inquery(vo.getAccountNo(), "2480");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.inquery(vo.getAccountNo()+100, "2480");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // 계좌 없음
		
		try {
			dao.inquery(vo.getAccountNo(), "0234");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // 패스워드 불일치
		
		AccountVO vo2 = null;
		try {
			vo2 = new AccountVO("조송희", "1357", 999);
			System.out.println("계좌생성");
			dao.createAccount(vo2); // 생성불가

			System.out.println("계좌조회");
			vo2 = dao.getAccount("김규익", "1357");
			dao.inquery(vo.getAccountNo(), "1357");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
