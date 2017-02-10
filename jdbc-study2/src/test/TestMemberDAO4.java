package test;

import java.sql.SQLException;

import model.MemberDAO;
import model.MemberVO;

public class TestMemberDAO4 {
	public static void main(String[] args) {
		try {
			MemberDAO dao = new MemberDAO();
			System.out.println("������ : " + dao.findMemberById("prince"));
			MemberVO vo = new  MemberVO("prince","dog","��������","�Ǳ�");
			dao.updateMember(vo);
			System.out.println("������ : " + dao.findMemberById("prince"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
