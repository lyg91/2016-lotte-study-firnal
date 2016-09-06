/** 패키지 선언문 */
package work.model.dao;

/** import 선언문 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * #Factory Pattern 
 * Factory 클래스 - 특정 공통기능을 제공하는 클래스
 * 
 * #FactoryDao Pattern
 * DAO 클래스의 공통 기능 : Connection 생성 및 자원해제
 * Singleton Pattern을 기본으로 적용 설계
 * 
 * #DAO 공통기능
 * 0.jdbc driver 로딩 : 생성자
 * 1.Connection 생성
 * 2.자원해제
 * 
 * #dbserver 관련 property파일을 외부에서 사용
 * 
 */

public class FactoryDao {
	//
	private String dsName = "java:comp/env/jdbc/Oracle"; // jdbc Connection pool이름
	private DataSource ds;
	
	private static FactoryDao instance = new FactoryDao();
	
	private FactoryDao() {
		try {
			ds = (DataSource)new InitialContext().lookup(dsName);
		} catch(NamingException e) {
			System.out.println("DataSource 이름 검색 실패");
		}
	}
	
	public static FactoryDao getInstance() {
		return instance;
	}
	
	public Connection getConnection() {	
		// Connection Pool ( DataSource)에게 COnnection 객체 하나 가져와서 받환
		try {
			return ds.getConnection();
		} catch(SQLException e) {
			System.out.println("");
			e.printStackTrace();
		}
		return null;
		// getConnection(id,pw)으로 중복정의 된 경우는 id와 pw를 xml파일로 가져오는 것이 
		// 보안상으로 문제가 될 수 있으므로 중복정의 되어있는 것.
	}
	
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}
}
