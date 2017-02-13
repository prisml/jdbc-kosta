package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {

	public ProductDAO() throws ClassNotFoundException {
		super();
		Class.forName(DbInfo.DRIVER);
	}

	public ProductVO findProductById(String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO pvo = null;
		try {
			String sql = "select * from product where id=?";
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				pvo = new ProductVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return pvo;
	}

	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void registerProduct(ProductVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "insert into product(id,name,maker,price) values(?,?,?,?)";
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getMaker());
			pstmt.setInt(4, vo.getPrice());
			pstmt.executeUpdate();
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	public ArrayList<ProductVO> getProductListByPrice(int lowPrice, int highPrice) throws SQLException {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from product where price>=? and price<=? order by price desc";
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, lowPrice);
			pstmt.setInt(2, highPrice);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(new ProductVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public ArrayList<String> getProductMakerKind() throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select distinct maker from product";
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(rs.getString(1));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	public ArrayList<ProductVO> getProductListDiscountPrice(int percent) throws SQLException {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select id,name,maker,price*(1-?/100) from product";
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, percent);
			rs = pstmt.executeQuery();
			while (rs.next())
				list.add(new ProductVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}
}
