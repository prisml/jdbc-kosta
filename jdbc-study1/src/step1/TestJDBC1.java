package step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC1 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 로딩");
			Connection con = DriverManager.getConnection(url, "scott", "tiger");
			System.out.println("오라클 데이터베이스 연결됨");
			String sql = "select * from member order by id asc";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { // 다음 row가 존재하면 true
				System.out.println(
						rs.getString(1) + " " + rs.getString(2) + " " + rs.getString("name") + " " + rs.getString(4));
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
