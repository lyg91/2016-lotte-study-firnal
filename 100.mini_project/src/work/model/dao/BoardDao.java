package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import work.model.dto.Board;

public class BoardDao {
	/* Factory Pattern */
	FactoryDao factory = FactoryDao.getInstance();

	/* Singleton Pattern */
	private BoardDao() {
	}

	private static BoardDao instance = new BoardDao();

	public static BoardDao getInstance() {
		return instance;
	}

	/**
	 * 1.게시판 전체조회 메서드
	 * 
	 * @param pageNum
	 *            조회할 페이지 번호
	 * @return 10페이지씩 반환
	 */
	public ArrayList<Board> selectBoardList(String pageNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pageNo = Integer.parseInt(pageNum);

		try {
			conn = factory.getConnection();
			String sql = "SELECT COUNT(b_number) FROM boards";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int bCount = 0;
			if (rs.next()) {
				bCount = rs.getInt(1);
				bCount = ((bCount / 10) == 0) ? (bCount / 10) : (bCount / 10) + 1;
			}

			if (pageNo == 0) {
				pageNo = 1;
			} else if (pageNo >= bCount) {
				pageNo = bCount;
			}

			pstmt.close();
			rs.close();

			sql = "SELECT b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM ( SELECT rownum as rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM (SELECT rownum AS rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM boards ORDER BY b_notice DESC, b_date DESC)) WHERE rown>=? AND rown<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ((pageNo - 1) * 10) + 1);
			pstmt.setInt(2, ((pageNo) * 10));
			rs = pstmt.executeQuery();

			ArrayList<Board> list = new ArrayList<Board>();
			Board dto = null;
			int bNumber = 0;
			String bTitle = null;
			String bContent = null;
			String bAuthor = null;
			String bDate = null;
			int bHit = 0;
			int bNotice = 0;

			while (rs.next()) {
				bNumber = rs.getInt(1);
				bTitle = rs.getString(2);
				bContent = rs.getString(3);
				bAuthor = rs.getString(4);
				bDate = rs.getString(5);
				bHit = rs.getInt(6);
				bNotice = rs.getInt(7);

				dto = new Board(bNumber, bTitle, 0, bContent, bAuthor, bDate, null, null, null, bHit, bNotice, 0, 0, 0,
						bCount);
				list.add(dto);
			}

			return list;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	/**
	 * 2. 게시글 등록메서드
	 * 
	 * @param bTitle
	 *            게시글 제목
	 * @param bPw
	 *            게시글 비밀번호
	 * @param bContent
	 *            게시글 내용
	 * @param bAuthor
	 *            게시ㅏㅈ
	 * @return 등록성공여부
	 */
	public int insertBoard(String bTitle, String bPw, String bContent, String bAuthor, String filePath1, String filePath2, String filePath3, int notice) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("notice:"+notice);
		try {
			conn = factory.getConnection();
			String sql = "INSERT INTO boards VALUES(seq_boards_number.nextval, ?, ?, ?, ?, to_char(sysdate,'yy/MM/dd hh:mm:ss'), ?, ?, ?, 0, "+notice+", 0, 0, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bTitle);
			pstmt.setString(2, bPw);
			pstmt.setString(3, bContent);
			pstmt.setString(4, bAuthor);
			pstmt.setString(5, filePath1);
			pstmt.setString(6, filePath2);
			pstmt.setString(7, filePath3);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close(conn, pstmt);
		}

		return 0;
	}

	public Board selectBoard(String boardNum, int flag) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = factory.getConnection();
			String sql = "SELECT * FROM boards WHERE b_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(boardNum));
			rs = pstmt.executeQuery();
			int bNumber = 0;
			String bTitle = null;
			int bPw = 0;
			String bContent = null;
			String bAuthor = null;
			String bDate = null;
			String bFile1 = null;
			String bFile2 = null;
			String bFile3 = null;
			int bHit = 0;
			int bNotice = 0;
			int bRecommend1 = 0;
			int bRecommend2 = 0;
			int bRecommend3 = 0;
			int bCount = 0;

			Board dto = null;

			if (rs.next()) {
				bNumber = rs.getInt(1);
				bTitle = rs.getString(2);
				bPw = rs.getInt(3);
				bContent = rs.getString(4);
				bAuthor = rs.getString(5);
				bDate = rs.getString(6);
				bFile1 = rs.getString(7);
				bFile2 = rs.getString(8);
				bFile3 = rs.getString(9);
				bHit = rs.getInt(10);
				bNotice = rs.getInt(11);
				bRecommend1 = rs.getInt(12);
				bRecommend2 = rs.getInt(13);
				bRecommend3 = rs.getInt(14);
				if(flag==0){
				    dto = new Board(bNumber, bTitle, bPw, bContent, bAuthor, bDate, bFile1, bFile2, bFile3, bHit+1, bNotice,
						bRecommend1, bRecommend2, bRecommend3, bCount);
				} else {
					dto = new Board(bNumber, bTitle, bPw, bContent, bAuthor, bDate, bFile1, bFile2, bFile3, bHit, bNotice,
							bRecommend1, bRecommend2, bRecommend3, bCount);
				}
				pstmt.close();
				
				if(flag == 0) {
					sql="UPDATE boards SET b_hit=?+1 WHERE b_number=?";
				
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, bHit);
					pstmt.setInt(2, Integer.parseInt(boardNum));
					pstmt.executeUpdate();
				} 
				
				return dto;
			}

		} catch (SQLException e) {

		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	public int deleteBoard(String boardNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = factory.getConnection();
			String sql = "DELETE FROM boards WHERE b_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(boardNum));

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}

	public int updateBoard(String bTitle, String bPw, String bContent, String boardNum, String filePath1, String filePath2, String filePath3) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = factory.getConnection();
			String sql = "UPDATE boards SET b_title=?, b_pw=?, b_content=?, b_date=to_char(sysdate,'yy/MM/dd hh24:mm:ss'), b_file1=?, b_file2=?, b_file3=? WHERE b_number=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bTitle);
			pstmt.setString(2, bPw);
			pstmt.setString(3, bContent);
			pstmt.setString(4, filePath1);
			pstmt.setString(5, filePath2);
			pstmt.setString(6, filePath3);
			pstmt.setInt(7, Integer.parseInt(boardNum));

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}

	public ArrayList<Board> selectBoardListSearch(String pageNum, String sType, String sTitle) { 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pageNo = Integer.parseInt(pageNum);
		
		try {
			conn = factory.getConnection();
			String sql = "SELECT COUNT(b_number) FROM boards";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int bCount = 0;
			
			if(rs.next()) {
				bCount = rs.getInt(1);
				bCount = ((bCount / 10) == 0) ? (bCount/10) : (bCount/10)+1; 
			}
			
			if(pageNo == 0) {
				pageNo = 1;
			} else if (pageNo >= bCount) {
				pageNo = bCount;
			}
			
			pstmt.close();
			rs.close();
			
			sql = "SELECT b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM ( SELECT rownum as rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM (SELECT rownum AS rown, b_number, b_title, b_content, b_author, b_date, b_hit, b_notice FROM boards WHERE "+sType+" LIKE ? ORDER BY b_notice DESC, b_date DESC)) WHERE rown>=? AND rown<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+sTitle+"%");
			pstmt.setInt(2, ((pageNo-1)*10)+1);
			pstmt.setInt(3, ((pageNo)*10));
			rs = pstmt.executeQuery();
			
			ArrayList<Board> list = new ArrayList<Board>();
			Board dto = null;
			int bNumber = 0; 
			String bTitle = null;
			String bContent = null;
			String bAuthor = null;
			String bDate = null;
			int bHit = 0;
			int bNotice = 0;
			
			while(rs.next()) {
				bNumber = rs.getInt(1);
				bTitle = rs.getString(2);
				bContent = rs.getString(3);
				bAuthor = rs.getString(4);
				bDate = rs.getString(5);
				bHit = rs.getInt(6);
				bNotice = rs.getInt(7);
				
				dto = new Board(bNumber, bTitle, 0, bContent, bAuthor, bDate, null, null, null, bHit, bNotice, 0, 0, 0, bCount);
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

	public int updateRecBoard(String rNum, String boardNum){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = factory.getConnection();
			String sql = "UPDATE boards SET B_RECOMMEND"+rNum+"=B_RECOMMEND"+rNum+"+1 WHERE B_NUMBER=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(boardNum));

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}

}
