package work.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import work.model.dao.MemberDao;
import work.model.dto.Member;
import work.util.Utility;

/**
 * 회원 관리 시스템에 대한 Service 클래스
 * -- 회원관리 시스템 기능 Business Logic 클래슨
 * @author Format
 *
 */
public class MemberService {
	/** 회원 dao */
	private MemberDao dao = MemberDao.getInstance();
	
	/** 로그인 요청 서비스 */
	public HashMap<String, String> login(String userId, String userPw) {
		return dao.login(userId, userPw);
	}
	
	/** 회원등록 요청 서비스 */
	public int insert(String userId, String userPw, String name, String mobile, String email) {
		Member dto = new Member(userId, userPw, name, mobile, email, "G", Utility.getCurrentDate(), 0, "임경혜");
		return dao.insert(dto);
	}
	
	/** 전체 회원 조회 서비스 */
	public ArrayList<Member> selectList() {
		return dao.selectList();
	}
	
	/** 특정 회원 조회 서비스 */
	public Member select(String userId) {
		return dao.select(userId);
	}
	
	/** 회원 탈퇴 서비스 */
	public int deleteMember(String userId) {
		return dao.deleteMember(userId);
	}
	
	/** 회원 변경 서비스 */
	public int updateMember(Member dto) {
		return dao.update(dto);
	}
}
