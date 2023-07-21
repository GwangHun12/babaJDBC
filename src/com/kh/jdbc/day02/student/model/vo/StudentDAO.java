package com.kh.jdbc.day01.student.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "STUDENT";
	private final String PASSWORD = "STUDENT";
	public List<Student> selectAll() {
			
	
			
			
			/*
			 * 1. 드라이버 등록
			 * 2. DB 연결 생성
			 * 3. 쿼리문 실행 준비
			 * 4. 쿼리문 실행 
			 * 5. 결과 받기
			 * 6. 자원해제(close())
			 */
	//		INSERT INTO STUDENT_TBL VALUES('khuser01', 'pass01', '일용자', 'M', 11, 'khuser01@kh.com', '서울시 중구 남대문로 120', '독서,수영', SYSDATE);
	//		String query = "INSERT INTO STUDENT_TBL VALUES('"+student.getStudentId()+"', '"+student.getStudentPwd()+"', '일용자', 'M', 11, 'khuser01@kh.com', '01012345678', '서울시 중구 남대문로 120', '독서,수영', SYSDATE)";
			String query = "SELECT * FROM STUDENT_TBL";
			List<Student> sList = new ArrayList<Student>();
			try {
				// 1. 드라이버 등록
				Class.forName(DRIVER_NAME);
				// 2. DB 연결 생성(DriverManger)
				Connection conn = 
				DriverManager.getConnection(URL, USER, PASSWORD);
				// 3. 쿼리문 실행 준비
				Statement stmt =
						conn.createStatement();
				ResultSet rset = 
						stmt.executeQuery(query);
				while(rset.next()) {
					Student student = rsetToStudent(rset);
	//				List<Student> sList = new ArrayList<Student>();
					sList.add(student);
	//				System.out.printf("아이디 : %s, 이름 : %s\n", rset.getString("STUDENT_STMT")
	//						 , rset.Email("ENOLL_DATE"));
				}
				rset.close();
				stmt.close();
				conn.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return sList;
		}

	//	public Student selectOneByName(String studentName) {
	//		String query = "SELECT * FROM STUDENT_TBL WHERE STUDENT_NAME ='" + studentName+"'";
	//		Student student = null;
	//		try {
	//			Class.forName(DRIVER_NAME);
	//			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
	//			Statement stmt = conn.createStatement();
	//			ResultSet rset = stmt.executeQuery(query);
	////			while(rset.next());{}
	//			if(rset.next()) {
	//				student = new Student();
	//				student.setStudentId(rset.getString("Student_ID"));
	//				student.setStudentPwd(rset.getString("STUDENT_PWD"));
	//				student.setStudentName(rset.getString("STUDENT_NAME"));
	//				student.setAge(rset.getInt("AGE"));
	//				student.setEmail(rset.getString("EMAIL"));
	//				student.setPhone(rset.getString("PHONE"));
	//				student.setGender(rset.getString("GENDER").charAt(0));
	//				student.setAddress(rset.getString("ADDRESS"));
	//				student.setHobby(rset.getString("HOBBY"));
	//				student.setEnrollDate(rset.getDate("ENROLL_DATE"));
	//			}
	//			rset.close();
	//			stmt.close();
	//			conn.close();
	//		} catch (ClassNotFoundException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return student;
	//	}
	
		public List<Student> selectAllByName(String studentName) {
			String query = "SELECT * FROM STUDENT_TBL WHERE STUDENT_NAME ='"+studentName+"'";
			List<Student> sList = new ArrayList<Student>();
			Student student = null;
			try {
				Class.forName(DRIVER_NAME);
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery(query);
				// 후처리
				while(rset.next()) {
					student = rsetToStudent(rset);
					sList.add(student);
				}
				rset.close();
				stmt.close();
				conn.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sList;
		}

	public Student selectOneById(String studentId) {
							// SELECT * FROM STUDENT_TBL WHERE STUDENT ID = 'khuser01'
			String query = "SELECT * FROM STUDENT_TBL WHERE STUDENT_ID ='" + studentId+"'";
			Student student = null;
			try {
				Class.forName(DRIVER_NAME);
				Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery(query);
	//			while(rset.next());{}
				if(rset.next()) {
					student = rsetToStudent(rset);
				}
				rset.close();
				stmt.close();
				conn.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return student;
		}

	

//	public Student selectOneByName(String studentName) {
//		String query = "SELECT * FROM STUDENT_TBL WHERE STUDENT_NAME ='" + studentName+"'";
//		Student student = null;
//		try {
//			Class.forName(DRIVER_NAME);
//			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			Statement stmt = conn.createStatement();
//			ResultSet rset = stmt.executeQuery(query);
////			while(rset.next());{}
//			if(rset.next()) {
//				student = new Student();
//				student.setStudentId(rset.getString("Student_ID"));
//				student.setStudentPwd(rset.getString("STUDENT_PWD"));
//				student.setStudentName(rset.getString("STUDENT_NAME"));
//				student.setAge(rset.getInt("AGE"));
//				student.setEmail(rset.getString("EMAIL"));
//				student.setPhone(rset.getString("PHONE"));
//				student.setGender(rset.getString("GENDER").charAt(0));
//				student.setAddress(rset.getString("ADDRESS"));
//				student.setHobby(rset.getString("HOBBY"));
//				student.setEnrollDate(rset.getDate("ENROLL_DATE"));
//			}
//			rset.close();
//			stmt.close();
//			conn.close();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return student;
//	}

	public int insertStudent(Student student) {
			/*
			 * 1. 드라이버 등록
			 * 2/ DB 연결 생성
			 * 3. 쿼리문 실행 준비
			 * 4. 쿼리문 실행 및 5. 결과 받기
			 * 6. 자원해제
			 * 
			 */
			
			String query = "INSERT INTO STUDENT_TBL VALUES("
					+"'"+student.getStudentId()+"', "
					+"'"+student.getStudentPwd()+"', "
					+"'"+student.getStudentName()+"', "
					+"'"+student.getGender()+"', "
					+"'"+student.getAge()+"',"
					+"'"+student.getEmail()+"', "
					+"'"+student.getEmail()+"', "
					+"'"+student.getAddress()+"', "
					+"'"+student.getHobby()+"', "+"SYSDATE)";
	//		String query = "";
			int result = -1;
			try {
				 // 1. 드라이버 등록
				Class.forName(DRIVER_NAME);
				 // 2/ DB 연결 생성
				Connection conn = 
				 DriverManager.getConnection(URL, USER, PASSWORD);
				// 3. 쿼리문 실행 준비
				Statement stmt = conn.createStatement();
				// 4. 실행하고 5. 결과받기
	//			stmt.executeQuery(query);	// SELECT용
				result = stmt.executeUpdate(query); 	// DML(INSERT, UPDATE, DELETE)
				stmt.close();
				conn.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}

	private Student rsetToStudent(ResultSet rset) throws SQLException {
		Student student = new Student();
		student.setStudentId(rset.getString("STUDENT_ID"));
		student.setStudentPwd(rset.getString("STUDENT_PWD"));
		student.setStudentName(rset.getString("STUDENT_NAME"));
		student.setAge(rset.getInt("AGE"));
		student.setEmail(rset.getString("EMAIL"));
		student.setPhone(rset.getString("PHONE"));
		student.setGender(rset.getString("GENDER").charAt(0));
		student.setAddress(rset.getString("ADDRESS"));
		student.setHobby(rset.getString("HOBBY"));
		student.setEnrollDate(rset.getDate("ENROLL_DATE"));
		return student;
	}

	public int deleteStudent(String studentId) {
		String query = "DELETE FROM STUDENT_TBL WHERE STUDENT_ID ='" + studentId+"'";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int updateStudent(Student student) {
//		UPDATE STUDENT_TBL SET STUDENT_PWD = 'pass11', EMAIL = 'khuser01@iei.or.kr', PHONE = '01012345678',
//				ADDRESS = '서울시 강남구', HOBBY = '코딩, 수영' WHERE STUDENT_ID = 'khuser01';
		String query = "UPDATE STUDENT_TBL SET " 
				+ "STUDENT_PWD = '"+student.getStudentPwd()+"', " 
					+ "EMAIL = '"+student.getEmail()+"', "
							+ "PHONE = '"+student.getPhone()+"', "
									+ "ADDRESS = '"+student.getAddress()+"', "
											+ "HOBBY = '"+student.getHobby()+"' "
													+ "WHERE STUDENT_ID = '"+student.getStudentId()+"'";
//		String query = "";
		int result = -1;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}


