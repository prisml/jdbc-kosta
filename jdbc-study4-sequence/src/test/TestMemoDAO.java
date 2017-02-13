package test;

import java.sql.SQLException;
import java.util.ArrayList;

import model.MemoDAO;
import model.MemoVO;

public class TestMemoDAO {
	public static void main(String[] args) {
		MemoDAO dao;
		try {
			dao = new MemoDAO();
			ArrayList<MemoVO> list = dao.getAllMemoList();
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
