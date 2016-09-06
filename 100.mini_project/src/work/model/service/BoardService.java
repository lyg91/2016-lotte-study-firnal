package work.model.service;

import java.util.ArrayList;

import work.model.dao.BoardDao;
import work.model.dto.Board;

public class BoardService {
	
	BoardDao dao = BoardDao.getInstance();
	
	public ArrayList<Board> selectBoardList(String pageNum) {
		return dao.selectBoardList(pageNum);
	}
	
	public int insertBoard(String bTitle, String bPw, String bContent, String bAuthor, String filePath1, String filePath2, String filePath3, int notice) {
		return dao.insertBoard(bTitle, bPw, bContent, bAuthor, filePath1, filePath2, filePath3, notice);
	}
	
	public Board selectBoard(String boardNum, int flag) {
		return dao.selectBoard(boardNum, flag);
	}
	
	public int updateBoard(String bTitle, String bPw, String bContent, String boardNum, String filepath1, String filepath2, String filepath3) {
		return dao.updateBoard(bTitle, bPw, bContent, boardNum, filepath1, filepath2, filepath3);
	}
	
	public int deleteBoard(String boardNum) {
		return dao.deleteBoard(boardNum);
	}
	
	public ArrayList<Board> selectBoardListSearch(String pageNum, String sType, String sTitle) {
		return dao.selectBoardListSearch(pageNum, sType, sTitle);
	}
	
	public int updateRecBoard(String rNum, String boardNum) {
		return dao.updateRecBoard(rNum, boardNum);
	}
}
