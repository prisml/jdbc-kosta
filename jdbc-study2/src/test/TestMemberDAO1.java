package test;

import model.MemberDAO;
import model.MemberVO;

public class TestMemberDAO1 {
	public static void main(String[] args) {
		try{
			MemberDAO dao = new MemberDAO();
			MemberVO vo = dao.findMemberById("java");
			if(vo != null)
				System.out.println("�˻���� : " + vo);
			else
				System.out.println("�˻��������");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
