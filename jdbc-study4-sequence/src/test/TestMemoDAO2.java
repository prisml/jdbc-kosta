package test;

import java.sql.SQLException;

import model.MemoDAO;
import model.MemoVO;

public class TestMemoDAO2 {
	public static void main(String[] args) {
		MemoDAO dao;
		try {
			dao = new MemoDAO();
			dao.insertMemo(new MemoVO("����޴�","�ɵ��"));
			System.out.println("�޸� ���");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
