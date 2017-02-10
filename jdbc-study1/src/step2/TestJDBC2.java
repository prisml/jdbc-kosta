package step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		try {
			Class.forName(driver);
			System.out.println("����̹� ���� ����");
			Connection con = DriverManager.getConnection(url,"scott","tiger");
			System.out.println("����Ŭ�����ͺ��̽� ����");
			String sql="insert into member(id,password,name,address) values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "spring"); // ù���� ����ǥ�� �����͸� �Ҵ�
			pstmt.setString(2, "aaaa"); 
			pstmt.setString(3, "�����"); 
			pstmt.setString(4, "����"); 
			int result = pstmt.executeUpdate();
			System.out.println("insert count:" + result);
			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
