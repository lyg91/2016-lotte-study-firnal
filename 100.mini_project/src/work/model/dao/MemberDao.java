/** 패키지 선언문 */
package work.model.dao;

/** import 선언문 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import work.model.dto.Member;
import work.util.Utility;

/** 
 * 회원 테이블 DAO 클래스 - SingleTon_Pattern 적용 설계
 * DAO 클래스 적용 Pattern

	1) SingleTon Pattern 
	- 하나의 클래스에 대해 하나의 객체(instance) 로만 서비스하도록 설계
	- 여러 사용자가 DB접근시 객체를 따로 만들지 않고 하나의 객체로 공유하여 사용하도록
	하기 위해 적용
	
	규칙
	1.생성자 접근권한 : private
	2.public static 클래스 getInstance() { return 클래스 인스턴스; } 
	- 해당 클래스의 객체를 하나만 반환하는 static 메서드 
	3.private static 클래스 인스턴스 변수 = new 클래스();
 
    2) Factory Pattern
 
 * members_dml.sql 참고
 */
public class MemberDao {
	/** Factory Pattern 적용 */
	
	private FactoryDao factory = FactoryDao.getInstance();
	
	/** Singleton Pattern 적용 => Driver Loaing 로직 Factory에게 위임*/
	
	private MemberDao() { }
	
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() { 
		return instance;
	}
	
/**	--1. 등록기능

	insert into members
	values('yhmoon','yh13579','문용휘','010-2065-4535','myh@empas.com','A','2015/05/05',null, null);
*/
	public int insert(Member dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String userId = dto.getUserId();
		String userPw = dto.getUserPw();
		String name = dto.getName();
		String mobile = dto.getMobile();
		String email = dto.getEmail();
		String grade = dto.getGrade();
		String entryDate = dto.getEntryDate();
		int mileage = dto.getMileage();
		String manager = dto.getManager();
		
		try {
			conn = factory.getConnection();
			String sql = "INSERT INTO members VALUES(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			pstmt.setString(3, name);
			pstmt.setString(4, mobile);
			pstmt.setString(5, email);
			pstmt.setString(6, grade);
			pstmt.setString(7, entryDate);
			pstmt.setInt(8, mileage);
			pstmt.setString(9, manager);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
/**
	--2. 전체 회원 조회 기능

	SELECT * 
	FROM members;
*/
	public ArrayList<Member> selectList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT * FROM members";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Member> list = new ArrayList<Member>();
			
			String userId = null;
			String userPw = null;
			String name = null;
			String mobile = null;
			String email = null;
			String grade = null;
			String entryDate = null;
			int mileage = 0;
			String manager = null;
			Member dto = null;
			
			while(rs.next()){
				userId = rs.getString(1);
				userPw = rs.getString(2);
				name = rs.getString(3);
				mobile = rs.getString(4);
				email = rs.getString(5);
				grade = rs.getString(6);
				entryDate = rs.getString(7);
				mileage = rs.getInt(8);
				manager = rs.getString(9);
				
				dto = new Member(userId,userPw,name,mobile,email,grade,entryDate,mileage,manager);
				list.add(dto);
			}
			
			return list;
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
/**	--3. 상세 회원 조회 기능

	SELECT * 
	FROM members
	WHERE user_id='jhgmananger';
*/
	public Member select(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT * FROM members WHERE user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			String userPw = null;
			String name = null;
			String mobile = null;
			String email = null;
			String grade = null;
			String entryDate = null;
			int mileage = 0;
			String manager = null;
			Member dto = null;
			
			while(rs.next()) {
				userId = rs.getString(1);
				userPw = rs.getString(2);
				name = rs.getString(3);
				mobile = rs.getString(4);
				email = rs.getString(5);
				grade = rs.getString(6);
				entryDate = rs.getString(7);
				mileage = rs.getInt(8);
				manager = rs.getString(9);
				
				dto = new Member(userId,userPw,name,mobile,email,grade,entryDate,mileage,manager);
			}			
			return dto;
		
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
/**	--4. 특정회원 정보 변경
	--사용자는 마일리지, 등급, 가입일, 담당자를 변경불가.

	UPDATE members
	SET user_pw='bluesky', name='이하니', mobile='010-1234-3333', email='hony@naver.com'
	WHERE user_id='jhgmanager';

	--관리자는 모든 사항을 변경가능

	UPDATE members
	SET user_pw='bluesky', name='이하니', mobile='010-1234-3333', email='hony@naver.com', grade='S', mileage=3000, entry_date='2016/07/29', manager='송중기'
	WHERE user_id='jhgmanager';
*/
	public int update(Member dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.getConnection();
			String sql = "UPDATE members SET user_pw=?, name=?, mobile=?, email=? WHERE user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getUserPw());
			pstmt.setString(2,dto.getName());
			pstmt.setString(3,dto.getMobile());
			pstmt.setString(4,dto.getEmail());
			pstmt.setString(5,dto.getUserId());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt);
		}
		
		return 0;
	}
	
/**	--5. 특정 회원 탈퇴 기능

	DELETE 
	FROM members
	WHERE user_id='lyg91' AND user_pw='a0309';

*/
	public int delete(String userId, String userPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.getConnection();
			String sql = "DELETE FROM members WHERE user_id=? AND user_pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			pstmt.setString(2,userPw);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	public int deleteMember(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.getConnection();
			String sql = "DELETE FROM members WHERE user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
/**	--6. 아이디 찾기

	SELECT user_id
	FROM members
	WHERE name='' AND mobile='';
*/
	public String selectId(String name, String mobile) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT user_id FROM members WHERE name=? AND mobile=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, mobile);
			rs = pstmt.executeQuery();
			
			String userId = null;
			
			if(rs.next()){
				userId = rs.getString(1);
			}			
			
			return userId;
		
		} catch (SQLException e) {
			
		} finally {

			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
/**	--7. 비밀번호 찾기 및 임시암호로 변경

	SELECT user_pw
	FROM members
	WHERE user_id='' AND email='';

	SELECT user_pw
	FROM members
	WHERE user_id='' AND mobile='';
	
	UPDATE members 
	SET user_pw=''
	WHERE user_id='';
*/
	public String selectPw(String userId, String mobile, String email, boolean flag) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = factory.getConnection();
			String sql = null;
			
			if(flag) {
				sql = "SELECT user_pw FROM members WHERE user_id=? AND mobile=?";
			} else {
				sql = "SELECT user_pw FROM members WHERE user_id=? AND email=?";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			if(flag) {
				pstmt.setString(1, userId);
				pstmt.setString(2, mobile);
			} else {
				pstmt.setString(1, userId);
				pstmt.setString(2, email);
			}
			
			rs = pstmt.executeQuery();
			String userPw = null;
			
			if(rs.next()){
				userPw = Utility.getSecureCode(10);
				pstmt.close();
				
				sql = "UPDATE members SET user_pw=? WHERE user_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userPw);
				pstmt.setString(2, userId);
				
				if (pstmt.executeUpdate() == 1)
					return userPw;
			}			
	
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;	
	}
	
/**	--8. 로그인 

	SELECT name,grade : HashMap
	FROM members
	WHERE user_id='' AND user_pw='';
*/
	public HashMap<String, String> login(String userId, String userPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT name,grade FROM members WHERE user_id=? AND user_pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			rs = pstmt.executeQuery();
			
			HashMap<String, String> map = new HashMap<String, String>();
	
			if(rs.next()){
				map.put("name",rs.getString(1)); 
				map.put("grade",rs.getString(2));
				return map;
			}			
			
			
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
/**	--9. 비밀번호 변경

	UPDATE members
	SET user_pw='1234'
	WHERE user_id='kkn0004' AND user_pw='k900820';
*/
	public int updatePw(String userId, String userPw, String newPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.getConnection();
			String sql = "UPDATE members SET user_pw=? WHERE user_id=? AND user_pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, userId);
			pstmt.setString(3, userPw);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt);
		}
		
		return 0;
	}
	
/**	--10. 테스트를 위한 전체 레코드 삭제

	DELETE 
	FROM members;
*/
	public void deleteList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.getConnection();
			String sql = "delete from members";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt);
		}
	}
	
/**	--11. 아이디 중복조회

	SELECT name
	FROM members
	WHERE user_id='kkn0004';
*/
	public String duplicateId(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT name FROM members WHERE user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return userId;
			}
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
/**	--12. 핸드폰 뒷 4자리 회원 조회

	SELECT *
	FROM members
	WHERE mobile LIKE ?;
	
	pstmt.setString(1,"%"+number);
*/
	public ArrayList<Member> selectPhone(String number) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT * FROM members WHERE mobile LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+number);
			rs = pstmt.executeQuery();
			
			String userId = null;
			String userPw = null;
			String name = null;
			String mobile = null;
			String email = null;
			String grade = null;
			String entryDate = null;
			int mileage = 0;
			String manager = null;
			Member dto = null;
			ArrayList<Member> list = new ArrayList<Member>();
			
			while(rs.next()) {
				userId = rs.getString(1);
				userPw = rs.getString(2);
				name = rs.getString(3);
				mobile = rs.getString(4);
				email = rs.getString(5);
				grade = rs.getString(6);
				entryDate = rs.getString(7);
				mileage = rs.getInt(8);
				manager = rs.getString(9);
				
				dto = new Member(userId, userPw, name, mobile, email, grade, entryDate, mileage, manager);
				list.add(dto);
			}
			
			return list;
			
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
/**	--13. 이름 부분 매칭 조회

	SELECT *
	FROM members
	WHERE name LIKE '%김%';
*/
	public ArrayList<Member> selectPartialName(String searchName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT * FROM members WHERE name LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchName+"%");
			rs = pstmt.executeQuery();
			
			String userId = null;
			String userPw = null;
			String name = null;
			String mobile = null;
			String email = null;
			String grade = null;
			String entryDate = null;
			int mileage = 0;
			String manager = null;
			Member dto = null;
			ArrayList<Member> list = new ArrayList<Member>();
			
			while(rs.next()) {
				userId = rs.getString(1);
				userPw = rs.getString(2);
				name = rs.getString(3);
				mobile = rs.getString(4);
				email = rs.getString(5);
				grade = rs.getString(6);
				entryDate = rs.getString(7);
				mileage = rs.getInt(8);
				manager = rs.getString(9);
				
				dto = new Member(userId,userPw,name,mobile,email,grade,entryDate,mileage,manager);
				list.add(dto);
			}
			
			return list;
			
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt, rs);
		}	
		return null;
	}
	
	public ArrayList<String> selectGrade() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT grade FROM members GROUP BY grade";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<String> list = new ArrayList<String>();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
			return list;
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	/** 정렬조건 : ID, 이름 , 등급, 마일리지, 가입일(최신,오래된) */
	public ArrayList<Member> selectSortedMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT * FROM members ORDER BY user_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Member> list = new ArrayList<Member>();
			
			String userId = null;
			String userPw = null;
			String name = null;
			String mobile = null;
			String email = null;
			String grade = null;
			String entryDate = null;
			int mileage = 0;
			String manager = null;
			Member dto = null;
			
			while(rs.next()){
				userId = rs.getString(1);
				userPw = rs.getString(2);
				name = rs.getString(3);
				mobile = rs.getString(4);
				email = rs.getString(5);
				grade = rs.getString(6);
				entryDate = rs.getString(7);
				mileage = rs.getInt(8);
				manager = rs.getString(9);
				
				dto = new Member(userId,userPw,name,mobile,email,grade,entryDate,mileage,manager);
				list.add(dto);
			}
			
			return list;
			
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	

	/** 등급별 회원조회 */
	public ArrayList<Member> groupedMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT * FROM members ORDER BY grade";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Member> list = new ArrayList<Member>();
			
			String userId = null;
			String userPw = null;
			String name = null;
			String mobile = null;
			String email = null;
			String grade = null;
			String entryDate = null;
			int mileage = 0;
			String manager = null;
			Member dto = null;
			
			while(rs.next()){
				userId = rs.getString(1);
				userPw = rs.getString(2);
				name = rs.getString(3);
				mobile = rs.getString(4);
				email = rs.getString(5);
				grade = rs.getString(6);
				entryDate = rs.getString(7);
				mileage = rs.getInt(8);
				manager = rs.getString(9);
				
				dto = new Member(userId, userPw, name, mobile, email, grade, entryDate, mileage, manager);
				list.add(dto);
			}
			
			return list;
			
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	/** 일반 회원의 마일리지 조회 */	
	public ArrayList<Integer> selectMileage() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT mileage FROM members WHERE grade='G'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			while(rs.next()) {
				list.add(rs.getInt(1));
			}
			
			return list;
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
	/** 마일리지가 50000이상인 회원 조회 
	 * + 관리자가 배치 등업기능 / 아이디, 마일리지 정보를 HashMap형식으로  
	 */
	public ArrayList<String> selectSpecials() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT name FROM members WHERE mileage>=50000";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<String> list = new ArrayList<String>();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
			return list;
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt, rs);
		}
		
		return null;
	}
	
	/** 회원등급 변경(회원 등업) */
	public int updateGrade(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.getConnection();
			String sql = "UPDATE members SET grade='A', mileage=null, manager=null WHERE user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt);
		}
		
		return 0;
	}
	
	/** 마일리지 변경 : 마일리지 정책 - 로그인시 100점 증가 */
	public int updateMileage(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.getConnection();
			String sql = "UPDATE members SET mileage=mileage+100 WHERE user_id=? AND grade='G'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}
}
