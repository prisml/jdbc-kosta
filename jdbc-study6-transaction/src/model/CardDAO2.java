package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDAO2 {

	public CardDAO2() throws ClassNotFoundException {
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
	 * 카드와 포이트 정보를 함께 database에 저장하는 메서드
	 * 카드등록
	 * 포인트 등록
	 * 위 두가지 업무가 모드 정상적으로 수행되었을 때
	 * 실제 데이터베이스에 반영(commit)
	 * 만약 두 업무 중 하나라도 문제 발생하면
	 * 모든 작업을 취소되도록 처리(rollback)
	 * 	try{
	 * 		트랜잭션 수동모드로 변경
	 * 		카드작업
	 * 		포인트작업
	 * 		commit
	 * 	}catch(){
	 * 		rollback
	 * 	}
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
			con.setAutoCommit(false);
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
			pstmt.setInt(2, point);
			int pointResult = pstmt.executeUpdate();
			System.out.println("point insert result : " + pointResult);
			con.commit();
			System.out.println("카드와 포인트 등록 완료(commit)");
		} catch(Throwable t){ // Exception 과 Error의 부모
			con.rollback();
			System.out.println("카드와 포인트 등록 작업 취소");
		}finally {
			closeAll(pstmt, con);
		}
	}
}
