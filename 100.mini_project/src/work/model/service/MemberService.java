package work.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import work.model.dao.MemberDao;
import work.model.dto.Member;
import work.util.Utility;

/**
 * ȸ�� ���� �ý��ۿ� ���� Service Ŭ����
 * -- ȸ������ �ý��� ��� Business Logic Ŭ����
 * @author Format
 *
 */
public class MemberService {
	/** ȸ�� dao */
	private MemberDao dao = MemberDao.getInstance();
	
	/** �α��� ��û ���� */
	public HashMap<String, String> login(String userId, String userPw) {
		return dao.login(userId, userPw);
	}
	
	/** ȸ����� ��û ���� */
	public int insert(String userId, String userPw, String name, String mobile, String email) {
		Member dto = new Member(userId, userPw, name, mobile, email, "G", Utility.getCurrentDate(), 0, "�Ӱ���");
		return dao.insert(dto);
	}
	
	/** ��ü ȸ�� ��ȸ ���� */
	public ArrayList<Member> selectList() {
		return dao.selectList();
	}
	
	/** Ư�� ȸ�� ��ȸ ���� */
	public Member select(String userId) {
		return dao.select(userId);
	}
	
	/** ȸ�� Ż�� ���� */
	public int deleteMember(String userId) {
		return dao.deleteMember(userId);
	}
	
	/** ȸ�� ���� ���� */
	public int updateMember(Member dto) {
		return dao.update(dto);
	}
}
