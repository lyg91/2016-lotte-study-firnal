package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import work.model.dto.User;

public class UserDao {
	/* Factory Pattern */
	FactoryDao factory = FactoryDao.getInstance();
	
	/* Singleton Pattern */
	private UserDao() { }
	private static UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	
	/** 1. insertUser : 회원가입 Dao 메서드 
	 * 
	 * @param dto 회원정보
	 * @return 1: 성공  0: 실패
	 */
	public int insertUser(User dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String uId = dto.getuId();
		String uPw = dto.getuPw();
		String uName = dto.getuName();
		String uMobile = dto.getuMobile();
		String uEmail = dto.getuEmail();
		String uGrade = dto.getuGrade();
		if(uGrade.equals("관리자")) {
			uGrade="A";
		} else {
			uGrade="G";
		}
		String uEntryDate = dto.getuEntryDate();
		int uMileage = dto.getuMileage();
		String uGender = dto.getuGender();
		if(uGender.equals("남자")) {
			uGender="M";
		} else {
			uGender="F";
		}
		int uBirthYear = dto.getuBirthYear();
		String uBirthMonday = dto.getuBirthMonday();
		
		try {
			conn = factory.getConnection();
			String sql = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uId);
			pstmt.setString(2, uPw);
			pstmt.setString(3, uName);
			pstmt.setString(4, uMobile);
			pstmt.setString(5, uEmail);
			pstmt.setString(6, uGrade);
			pstmt.setString(7, uEntryDate);
			pstmt.setInt(8, uMileage);
			pstmt.setString(9, uGender);
			pstmt.setInt(10, uBirthYear);
			pstmt.setString(11, uBirthMonday);
			
			return pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	/** 2. loginUser : 로그인 Dao 메서드 
	 * 
	 * @param uId 로그인 ID
	 * @param uPw 로그인 PW
	 * @return 로그인 성공시 이름, 등급 정보를 저장한 HashMap
	 */
	public HashMap<String, String> loginUser(String uId, String uPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT u_name, u_grade FROM users WHERE u_Id=? AND u_Pw=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, uId);
			pstmt.setString(2, uPw);
			
			HashMap<String, String> map = new HashMap<String, String>(); 
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				map.put("name", rs.getString("u_name"));
				map.put("grade", rs.getString("u_grade"));
				return map;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally { 
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	/** 3. 아이디 검색 메서드
	 * 
	 * @param uName 검색에 사용할 사용자 이름
	 * @param uMoblie 검색에 사용할 사용자 연락처
	 * @return 검색된 ID
	 */
	public String selectId(String uName, String uMobile) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.getConnection();
			String sql = "SELECT u_id FROM users WHERE u_name=? AND u_mobile=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uName);
			pstmt.setString(2, uMobile);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString(1);
			}
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	/** 4. 패스워드 검색 메서드
	 * 
	 * @param uId
	 * @param uName
	 * @param uMobile
	 * @return
	 */
	public String selectPw(String uId, String uName, String uMobile) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT u_pw FROM users WHERE u_id=? AND u_name=? AND u_mobile=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uId);
			pstmt.setString(2, uName);
			pstmt.setString(3, uMobile);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				return rs.getString(1);
			}
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	public User selectInfo(String uId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT * FROM users WHERE u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uId);
			
			rs = pstmt.executeQuery();
			User dto = null;
			if(rs.next()) { 
				 String uPw = rs.getString(2);
				 String uName = rs.getString(3);
				 String uMobile = rs.getString(4);
				 String uEmail = rs.getString(5);
				 String uGrade = rs.getString(6);
				 String uEntryDate = rs.getString(7);
				 int uMileage = rs.getInt(8);
				 String uGender = rs.getString(9);
				 int uBirthYear = rs.getInt(10);
				 String uBirthMonday = rs.getString(11);
				 dto = new User(uId, uPw, uName, uMobile, uEmail, uGrade, uEntryDate, uMileage, uGender, uBirthYear, uBirthMonday);
				 return dto;
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	/** 전체회원 조회 메서드
	 * 
	 * @return 전체회원 리스트
	 */
	public ArrayList<User> selectUserList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT * FROM users ORDER BY u_entry_date DESC";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			User dto = null;
			ArrayList<User> list = new ArrayList<User>();
			
			while(rs.next()) { 
				System.out.println("check");
				 String uId = rs.getString(1);
				 String uPw = rs.getString(2);
				 String uName = rs.getString(3);
				 String uMobile = rs.getString(4);
				 String uEmail = rs.getString(5);
				 String uGrade = rs.getString(6);
				 String uEntryDate = rs.getString(7);
				 int uMileage = rs.getInt(8);
				 String uGender = rs.getString(9);
				 int uBirthYear = rs.getInt(10);
				 String uBirthMonday = rs.getString(11);
				 dto = new User(uId, uPw, uName, uMobile, uEmail, uGrade, uEntryDate, uMileage, uGender, uBirthYear, uBirthMonday);
				 list.add(dto);
			}
			return list;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	public int deleteUserAdmin(String uId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.getConnection();
			String sql = "DELETE users WHERE u_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uId);
			
			return pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
}
