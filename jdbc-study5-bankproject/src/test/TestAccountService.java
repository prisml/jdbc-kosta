package test;

import dao.AccountDAO;
import model.AccountVO;

public class TestAccountService {
	public static void main(String[] args) {
		try {
			AccountVO vo = new AccountVO("¹Ú¿µ´ö", "1234", 2000);
			AccountDAO dao = new AccountDAO();
			System.out.println("°èÁÂ»ı¼º");
			dao.createAccount(vo);
			
			System.out.println("°èÁÂÁ¶È¸");
			vo = dao.getAccount("¹Ú¿µ´ö","1234");
			dao.inquery(vo.getAccountNo(),"1234");
			
			System.out.println("ÀÔ±İ");
			dao.deposit(vo.getAccountNo(),50000);
			dao.inquery(vo.getAccountNo(),"1234");
			
			System.out.println("Ãâ±İ");
			dao.withdraw(vo.getAccountNo(),"1234",30000);
			dao.inquery(vo.getAccountNo(),"1234");
			
			System.out.println("°èÁÂ»ı¼º2");
			AccountVO vo2 = new AccountVO("±è±ÔÀÍ", "1234", 3000);
			dao.createAccount(vo2);
			
			System.out.println("°èÁÂÁ¶È¸");
			vo2 = dao.getAccount("±è±ÔÀÍ","1234");
			dao.inquery(vo2.getAccountNo(),"1234");
			
			System.out.println("°èÁÂÀÌÃ¼");
			dao.transfer(vo.getAccountNo(),"1234",vo2.getAccountNo(),5000);
			dao.inquery(vo.getAccountNo(),"1234");
			dao.inquery(vo2.getAccountNo(),"1234");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
