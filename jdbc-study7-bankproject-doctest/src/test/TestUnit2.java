package test;

import java.sql.SQLException;

import model.AccountDAO;
import model.AccountLoginException;


//step2 ���� �ܾ���ȸ �׽�Ʈ
public class TestUnit2 {
	public static void main(String[] args) {		
		try {
			AccountDAO dao = new AccountDAO();
			System.out.println("�ܾ���ȸ:" 
			+ dao.selectBalance("2", "1234"));
		}catch (AccountLoginException e) {			
			System.out.println(e.getMessage());			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}