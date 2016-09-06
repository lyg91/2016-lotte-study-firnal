/** ��Ű�� ���� */
package work.model.dao;

/** import ���� */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * #Factory Pattern 
 * Factory Ŭ���� - Ư�� �������� �����ϴ� Ŭ����
 * 
 * #FactoryDao Pattern
 * DAO Ŭ������ ���� ��� : Connection ���� �� �ڿ�����
 * Singleton Pattern�� �⺻���� ���� ����
 * 
 * #DAO ������
 * 0.jdbc driver �ε� : ������
 * 1.Connection ����
 * 2.�ڿ�����
 * 
 * #dbserver ���� property������ �ܺο��� ���
 * 
 */

public class FactoryDao {
	//
	private String dsName = "java:comp/env/jdbc/Oracle"; // jdbc Connection pool�̸�
	private DataSource ds;
	
	private static FactoryDao instance = new FactoryDao();
	
	private FactoryDao() {
		try {
			ds = (DataSource)new InitialContext().lookup(dsName);
		} catch(NamingException e) {
			System.out.println("DataSource �̸� �˻� ����");
		}
	}
	
	public static FactoryDao getInstance() {
		return instance;
	}
	
	public Connection getConnection() {	
		// Connection Pool ( DataSource)���� COnnection ��ü �ϳ� �����ͼ� ��ȯ
		try {
			return ds.getConnection();
		} catch(SQLException e) {
			System.out.println("");
			e.printStackTrace();
		}
		return null;
		// getConnection(id,pw)���� �ߺ����� �� ���� id�� pw�� xml���Ϸ� �������� ���� 
		// ���Ȼ����� ������ �� �� �����Ƿ� �ߺ����� �Ǿ��ִ� ��.
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
