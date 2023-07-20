package com.kh.jdbc.day01.student.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {

	public static void main(String[] args) {
		/*
		 * 1. 드라이버 등록
		 * 2. DB 연결 생성
		 * 3. 쿼리문 실행 준비
		 * 4. 쿼리문 실행 
		 * 5. 결과 받기
		 * 6. 자원해제(close())
		 */
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "STUDENT";
		String password = "STUDENT";
		String query = "SELECT * FROM STUDENT_TBL";
		try {
			// 1. 드라이버 등록
			Class.forName(driverName);
			// 2. DB 연결 생성(DriverManger)
			Connection conn = 
			DriverManager.getConnection(url, user, password);
			// 3. 쿼리문 실행 준비
			Statement stmt =
					conn.createStatement();
			ResultSet rset = 
					stmt.executeQuery(query);
			while(rset.next()) {
				System.out.printf("아이디 : %s, 이름 : %s\n", rset.getString("STUDENT_ID")
						 , rset.getString("STUDENT_NAME"));
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
