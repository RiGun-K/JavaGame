package database;

import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.io.*;

public class DBConnection {
	
	private static ResultSet rs;
	private static final String ID = "root";
	private static final String PW = "4238";
	private static final String URL = "jdbc:mariadb://127.0.0.1:3306/javagame";
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
	
	public static void insertTable(String id, Object pw) {
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(URL,ID,PW);
			PreparedStatement insert = con.prepareStatement (""
					+ "INSERT INTO users"
					+ "(id, pw)"
					+ "VALUES"
					+ "('"+id+"','"+pw+"')");
			
			insert.executeUpdate();
			System.out.println("데이터가 저장되었습니다.");
		} 
		
		catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
			
		}
	}
	
	// 그냥 단순 조회용 
	public static void selectTable() {
			
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(URL,ID,PW);
			String sql = "select * from users ORDER BY `score` DESC";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String score = rs.getString("score");
				
				System.out.println("아이디 :"+ id + " 비밀번호 :"+ pw + " 점수 :"+ score);
			}
				
			
		} 
		
		catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
			
		}
		
	}
	
	public static String[][] getRank() {
		try {
			Class.forName(JDBC_DRIVER);
			Connection con = DriverManager.getConnection(URL,ID,PW);
			String sql = "select * from users ORDER BY `score` DESC";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			
			
			while(rs.next()) {
				list.add(new String[] {
						rs.getString("id"),
						rs.getString("pw"),
						rs.getString("score")
				});
				
				System.out.println("The data has been fetched");
				
				String[][] arr = new String[list.size()][3];
				return list.toArray(arr);
			}
				
			
		} 
		
		catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
			
		}
		return getRank();
	}
		
	public static void main(String[] args) {
//		selectTable();
//		insertTable("리건","관리자");
	
	}
}
