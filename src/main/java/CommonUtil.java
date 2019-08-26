package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

public class CommonUtil {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://node42996-env-0066624.cloud.cms500.com:3306/auto_trade?useSSL=false";
	//static final String DB_URL = "jdbc:mysql://localhost:3306/auto_trade?useSSL=false";
	static final String password = "TDAtlc11198";
	//static final String password = "root";
	static Connection conn = null;
	static Statement stmt = null;

	public static void openDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, "root", password);
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeDBConnection() {
		try {
			if (stmt != null)
				conn.close();
		} catch (SQLException se) {

		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public static Date getNextCalendarDate(Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		return calendar.getTime();
	}
}
