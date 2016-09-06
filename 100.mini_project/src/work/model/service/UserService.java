package work.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import work.model.dao.UserDao;
import work.model.dto.User;

public class UserService {
	private UserDao dao = UserDao.getInstance();
	
	public int insertUser(User dto) {
		return dao.insertUser(dto);
	}
	
	public HashMap<String, String> loginUser(String uId, String uPw) {
		return dao.loginUser(uId, uPw);
	}
	
	public String selectId(String uName, String uMobile) {
		return dao.selectId(uName, uMobile);
	}
	
	public String selectPw(String uId, String uName, String uMobile) {
		return dao.selectPw(uId, uName, uMobile);
	}
	
	public User selectInfo(String uId) {
		return dao.selectInfo(uId);
	}
	
	public ArrayList<User> selectUserList() {
		return dao.selectUserList();
	}
	
	public int deleteUserAdmin(String uId) {
		return dao.deleteUserAdmin(uId);
	}
}
