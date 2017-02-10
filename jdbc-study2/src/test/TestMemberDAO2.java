package test;

import java.sql.SQLException;

import model.MemberDAO;
import model.MemberVO;

public class TestMemberDAO2 {
	public static void main(String[] args) {
		try {
			MemberDAO dao = new MemberDAO();
			MemberVO vo = new MemberVO("prince", "angel", "김문일", "개성공단");
			if (dao.findMemberById(vo.getId()) == null) {
				dao.registerMember(vo);
				System.out.println(vo + " insert ok");
			} else {
				System.out.println("회원 아이디가 존재합니다");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
