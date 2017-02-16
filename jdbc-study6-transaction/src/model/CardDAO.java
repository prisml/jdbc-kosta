package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDAO {

	public CardDAO() throws ClassNotFoundException {
		super();
		Class.forName(DbInfo.DRIVER);
	}

	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		closeAll(null, pstmt, con);
	}

	/**
	 * 아래 메서드는 카드 발급시 반드시 포인트도 지급되어야
	 * 하는 업무에서
	 * 카드만 발급되고 포인트 지급시점에서 문제 발생하여
	 * db에 카드정보는 insert, 포인트정보는 insert되지 않은 상태
	 * --> 이런 경우에는 별도의 트랜잭션처리가 필요하다
	 * @param id
	 * @param name
	 * @param point
	 * @throws SQLException
	 */
	public void registerCard(String id, String name, int point) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			String cardSql = "insert into card(id,name) values(?,?)";
			pstmt = con.prepareStatement(cardSql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			int cardResult = pstmt.executeUpdate();
			System.out.println("card insert result : " + cardResult);
			pstmt.close();
			String pointSql = "insert into point(id,point) values(?,?)";
			pstmt = con.prepareStatement(pointSql);
			pstmt.setString(1, id);
			int pointResult = pstmt.executeUpdate();
			System.out.println("point insert result : " + pointResult);
		} finally {
			closeAll(pstmt, con);
		}
	}
}
