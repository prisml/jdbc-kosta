package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.InitializationFaultException;
import exception.LackOfBalanceException;
import exception.NegativeAmountException;
import exception.NotFoundAccountException;
import exception.PasswordNotMatchException;
import model.AccountVO;
import util.DbInfo;

public class AccountDAO {

	public AccountDAO() throws ClassNotFoundException {
		super();
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

	private int checkAccount(int accountNo) throws SQLException, NotFoundAccountException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			String sql = "select balance from account where account_no=?";
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountNo);
			rs = pstmt.executeQuery();
			if (!rs.next())
				throw new NotFoundAccountException(accountNo + "");
			result = rs.getInt(1);
		} finally {
			closeAll(rs, pstmt, con);
		}
		return result;
	}

	public void createAccount(AccountVO vo) throws SQLException, InitializationFaultException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			if (vo.getBalance() < 1000)
				throw new InitializationFaultException();
			String sql = "insert into account(account_no,name,password,balance)"
					+"values(memo_seq.nextval,?,?,?)";
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setInt(3, vo.getBalance());
			pstmt.executeUpdate();
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	public AccountVO getAccount(String name, String password) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AccountVO vo = null;
		try {
			String sql = "select * from account where name=? and password=?";
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next())
				vo = new AccountVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
		} finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}

	public void inquery(int accountNo, String password)
			throws SQLException, NotFoundAccountException, PasswordNotMatchException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AccountVO vo = null;
		try {
			checkAccount(accountNo);
			String sql = "select * from account where account_no=? "
					+"and password=?";
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, accountNo);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next())
				vo = new AccountVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			if (vo == null)
				throw new PasswordNotMatchException();
			System.out.println(vo);
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	public void deposit(int accountNo, int money)
			throws SQLException, NotFoundAccountException, NegativeAmountException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			if (money <= 0)
				throw new NegativeAmountException();
			checkAccount(accountNo);
			String sql = "update account set balance=balance+? where account_no=?";
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setInt(2, accountNo);
			pstmt.executeUpdate();
		} finally {
			closeAll(rs, pstmt, con);
		}
	}

	public void withdraw(int accountNo, String password, int money)
			throws SQLException, NotFoundAccountException, PasswordNotMatchException, LackOfBalanceException, NegativeAmountException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			int balance = checkAccount(accountNo);
			if(money <= 0)
				throw new NegativeAmountException();
			if (balance < money)
				throw new LackOfBalanceException();
			String sql = "update account set balance=balance-? where account_no=? and password=?";
			con = DriverManager.getConnection(DbInfo.URL, "scott", "tiger");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setInt(2, accountNo);
			pstmt.setString(3, password);
			if (pstmt.executeUpdate() == 0)
				throw new PasswordNotMatchException();
		} finally {
			closeAll(rs, pstmt, con);
		}

	}

	public void transfer(int accountNo, String password, int accountNo2, int money) throws 
			LackOfBalanceException, NotFoundAccountException, PasswordNotMatchException, NegativeAmountException {
		int balance;
		try {
			balance = checkAccount(accountNo);
			if (balance < money)
				throw new LackOfBalanceException();
			checkAccount(accountNo2);
			withdraw(accountNo, password, money);
			deposit(accountNo2, money);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
