/** ��Ű�� ���� */
package work.model.dao;

/** import ���� */
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
 * ȸ�� ���̺� DAO Ŭ���� - SingleTon_Pattern ���� ����
 * DAO Ŭ���� ���� Pattern

	1) SingleTon Pattern 
	- �ϳ��� Ŭ������ ���� �ϳ��� ��ü(instance) �θ� �����ϵ��� ����
	- ���� ����ڰ� DB���ٽ� ��ü�� ���� ������ �ʰ� �ϳ��� ��ü�� �����Ͽ� ����ϵ���
	�ϱ� ���� ����
	
	��Ģ
	1.������ ���ٱ��� : private
	2.public static Ŭ���� getInstance() { return Ŭ���� �ν��Ͻ�; } 
	- �ش� Ŭ������ ��ü�� �ϳ��� ��ȯ�ϴ� static �޼��� 
	3.private static Ŭ���� �ν��Ͻ� ���� = new Ŭ����();
 
    2) Factory Pattern
 
 * members_dml.sql ����
 */
public class MemberDao {
	/** Factory Pattern ���� */
	
	private FactoryDao factory = FactoryDao.getInstance();
	
	/** Singleton Pattern ���� => Driver Loaing ���� Factory���� ����*/
	
	private MemberDao() { }
	
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() { 
		return instance;
	}
	
/**	--1. ��ϱ��

	insert into members
	values('yhmoon','yh13579','������','010-2065-4535','myh@empas.com','A','2015/05/05',null, null);
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
	--2. ��ü ȸ�� ��ȸ ���

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
	
/**	--3. �� ȸ�� ��ȸ ���

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
	
/**	--4. Ư��ȸ�� ���� ����
	--����ڴ� ���ϸ���, ���, ������, ����ڸ� ����Ұ�.

	UPDATE members
	SET user_pw='bluesky', name='���ϴ�', mobile='010-1234-3333', email='hony@naver.com'
	WHERE user_id='jhgmanager';

	--�����ڴ� ��� ������ ���氡��

	UPDATE members
	SET user_pw='bluesky', name='���ϴ�', mobile='010-1234-3333', email='hony@naver.com', grade='S', mileage=3000, entry_date='2016/07/29', manager='���߱�'
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
	
/**	--5. Ư�� ȸ�� Ż�� ���

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
	
/**	--6. ���̵� ã��

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
	
/**	--7. ��й�ȣ ã�� �� �ӽþ�ȣ�� ����

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
	
/**	--8. �α��� 

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
	
/**	--9. ��й�ȣ ����

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
	
/**	--10. �׽�Ʈ�� ���� ��ü ���ڵ� ����

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
	
/**	--11. ���̵� �ߺ���ȸ

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
	
/**	--12. �ڵ��� �� 4�ڸ� ȸ�� ��ȸ

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
	
/**	--13. �̸� �κ� ��Ī ��ȸ

	SELECT *
	FROM members
	WHERE name LIKE '%��%';
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
	
	/** �������� : ID, �̸� , ���, ���ϸ���, ������(�ֽ�,������) */
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
	

	/** ��޺� ȸ����ȸ */
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
	
	/** �Ϲ� ȸ���� ���ϸ��� ��ȸ */	
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
	
	/** ���ϸ����� 50000�̻��� ȸ�� ��ȸ 
	 * + �����ڰ� ��ġ ������ / ���̵�, ���ϸ��� ������ HashMap��������  
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
	
	/** ȸ����� ����(ȸ�� ���) */
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
	
	/** ���ϸ��� ���� : ���ϸ��� ��å - �α��ν� 100�� ���� */
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
