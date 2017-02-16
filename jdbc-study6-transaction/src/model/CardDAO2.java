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
	 * ī��� ����Ʈ ������ �Բ� database�� �����ϴ� �޼���
	 * ī����
	 * ����Ʈ ���
	 * �� �ΰ��� ������ ��� ���������� ����Ǿ��� ��
	 * ���� �����ͺ��̽��� �ݿ�(commit)
	 * ���� �� ���� �� �ϳ��� ���� �߻��ϸ�
	 * ��� �۾��� ��ҵǵ��� ó��(rollback)
	 * 	try{
	 * 		Ʈ����� �������� ����
	 * 		ī���۾�
	 * 		����Ʈ�۾�
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
			System.out.println("ī��� ����Ʈ ��� �Ϸ�(commit)");
		} catch(Throwable t){ // Exception �� Error�� �θ�
			con.rollback();
			System.out.println("ī��� ����Ʈ ��� �۾� ���");
		}finally {
			closeAll(pstmt, con);
		}
	}
}
