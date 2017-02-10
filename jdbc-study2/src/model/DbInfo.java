package model;

public interface DbInfo {
	// public static final이 자동 삽입
	String DRIVER = "oracle.jdbc.driver.OracleDriver";
	String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
}
