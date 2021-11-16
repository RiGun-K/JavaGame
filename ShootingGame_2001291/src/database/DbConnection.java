package database;

import java.net.*;
import java.io.*;
import java.sql.*;
import java.io.*;

public class DbConnection {
	
	static Connection con = null;
	private static ResultSet rs;
	private static final String ID = "root";
	private static final String PW = "4238";
	private static final String URL = "jdbc:mariadb://127.0.0.1:3306/javagame";
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	
	public static void main(String[] args) {
			
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(URL,ID,PW);
			String sql = "select * from users";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				
				System.out.println("아이디 :"+ id + " 비밀번호 :"+ pw);
			}
				
			
		}
		
		catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
			
		}
		
		
	}
}
