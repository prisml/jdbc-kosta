package test;

import java.sql.SQLException;

import model.MemberDAO;
import model.MemberVO;

public class TestMemberDAO4 {
	public static void main(String[] args) {
		try {
			MemberDAO dao = new MemberDAO();
			System.out.println("수정전 : " + dao.findMemberById("prince"));
			MemberVO vo = new  MemberVO("prince","dog","민정수석","판교");
			dao.updateMember(vo);
			System.out.println("수정후 : " + dao.findMemberById("prince"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
