package com.kbigdata.contactApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @filename : JDBCTemplete.java 
 * @project : contactApp 
 * @date : 2022. 3. 10.
 * @author : 박다울 
 * @version : 1.0
 * @description : 데이터베이스 연동
 */
public class JDBCTemplete {

	/**
	 * @methodname : getConnection 
	 * @date : 2022. 3. 10.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : Connection 생성
	 * @return : Connection
	 */
	public static Connection getConnection() {
		Connection con 	= null;
		String driver	= "oracle.jdbc.driver.OracleDriver";
		String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
		String user 	= "ora_user";
		String password = "hong";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * @methodname : close 
	 * @date : 2022. 3. 10.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : Connection close
	 * @param con : Connection
	 * @param stmt : Statement  
	 */
	public static void close(Connection con, Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @methodname : close 
	 * @date : 2022. 3. 10.
	 * @author : 박다울
	 * @version : 1.0
	 * @description : Connection close
	 * @param con : Connection
	 * @param stmt : Statement
	 * @param re : ResultSet
	 */
	public static void close(Connection con, Statement stmt, ResultSet re) {
		if(re != null) {
			try {
				re.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(con, stmt);
	}
}
