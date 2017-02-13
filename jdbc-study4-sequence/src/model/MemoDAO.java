package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemoDAO {
	

	public MemoDAO() throws ClassNotFoundException {
		Class.forName(DbInfo.DRIVER);
	}

	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public ArrayList<MemoVO> getAllMemoList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemoVO> list = new ArrayList<MemoVO>();
		try {
			String sql = "select * from memo order by memo_no desc";
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(new MemoVO(rs.getInt(1), rs.getString(2), rs.getString(3)));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public void insertMemo(MemoVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into memo(memo_no,title,content) values(memo_seq.nextval,?,?)";
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.executeUpdate();
		} finally {
			closeAll(rs, pstmt, con);
		}		
	}

}
