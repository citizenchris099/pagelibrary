package com.balfour.publishing.qa.pages.sb4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * special utility class whose methods are used to interrogate databases.
 * 
 * @author cmanning
 * 
 */
public class DbUtil {

	public static void BaanData(String orno, String lname) throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {

		String url = "jdbc:oracle:thin:@//10.160.1.79:1521/BAANTEST";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String userName = "tops";
		String password = "tops12";

		// create object of driver
		Class.forName(driver).newInstance();

		// establish connection
		Connection conn1 = DriverManager.getConnection(url, userName, password);

		PreparedStatement pstmt = conn1
				.prepareStatement("select * from triton.Ttmsls961100 where t$orno= ?");

		pstmt.setString(1, orno);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			String lastName = rs.getString("t$namb");

			if (!lastName.equals(lname)) {
				throw new RuntimeException("lastName values didn't match");
			}

		}
		pstmt.close();
		conn1.close();
	}

	/**
	 * used to interrogate mysql db and get specific value from specific field
	 * 
	 * @param val
	 *            : variable used within prepared statement
	 * @param stmt
	 *            : prepared statement
	 * @param url
	 *            : database url to be used
	 * @param userName
	 *            : database username to be used
	 * @param password
	 *            : database password to be used
	 * @param val2
	 *            : the field containing the desired information
	 * @return: info from val2 returned as string
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public String B4PubData(String val, String stmt, String url,
			String userName, String password, String val2) throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {

		String driver = "com.mysql.jdbc.Driver";

		// create object of driver
		Class.forName(driver).newInstance();

		// establish connection
		Connection conn1 = DriverManager.getConnection(url, userName, password);

		PreparedStatement pstmt = conn1.prepareStatement(stmt);

		pstmt.setString(1, val);
		String key = null;

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			key = rs.getString(val2);

		}
		pstmt.close();
		conn1.close();
		return key;
	}
}
