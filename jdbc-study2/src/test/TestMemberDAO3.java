package test;

import java.sql.SQLException;
import java.util.ArrayList;

import model.MemberDAO;
import model.MemberVO;

public class TestMemberDAO3 {
	public static void main(String[] args) {
		try {
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberVO> list = dao.getAllMemberList();
			for(int i=0;i<list.size();i++)
				System.out.println(list.get(i));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
