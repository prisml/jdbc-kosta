package test;

import java.sql.SQLException;

import model.MemoDAO;
import model.MemoVO;

public class TestMemoDAO2 {
	public static void main(String[] args) {
		MemoDAO dao;
		try {
			dao = new MemoDAO();
			dao.insertMemo(new MemoVO("저녁메뉴","꽃등심"));
			System.out.println("메모 등록");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
