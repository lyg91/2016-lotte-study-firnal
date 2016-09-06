/** ��Ű�� ���� */
package work.model.dto;
import java.io.Serializable;

/**
 * @author �̿���
 * @version ver 1.0
 * @since JDK 1.4
 */
/** ȸ�� Ŭ���� */
public class Member implements Serializable{
	/** ȸ�� ID ������� ���� �� ����� �ʱ�ȭ */
	private String userId = "GUEST";

	/** ȸ�� PW ������� ���� */
	private String userPw;

	/** ȸ�� �̸� ������� ���� */
	private String name;

	/** ȸ�� ��ȣ ������� ���� */
	private String mobile;

	/** ȸ�� �̸��� ������� ���� */
	private String email;
	
	/** ȸ�� ��� ������� ���� */
	private String grade;

	/** ȸ�� ����� ������� ���� */
	private String entryDate;
	
	/** �Ϲ�ȸ�� ���ϸ��� ������� ���� */
	private int mileage;
	
	/** ���ȸ�� ����� ������� ���� */
	private String manager;
	
	
	public Member() { }

	public Member(String userId, String userPw, String name, String mobile, String email, String grade,
			String entryDate, int mileage, String manager) {
		this.userId = userId;
		this.userPw = userPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.grade = grade;
		this.entryDate = entryDate;
		this.mileage = mileage;
		this.manager = manager;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrade() {
		if(grade.equals("A")) { 
			return "������";
		} else if (grade.equals("S")) {
			return "���ȸ��";
		} else if (grade.equals("G")){
			return "�Ϲ�ȸ��";
		} else { 
			return "��Ÿ";
		}
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getManager() {
		if(manager==null) {
			return "   ";
		} else {
			return manager;
		}
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" ID=");
		builder.append(userId);
		builder.append("\n ��й�ȣ=");
		builder.append(userPw);
		builder.append("\n �̸�=");
		builder.append(name);
		builder.append("\n ����ó=");
		builder.append(mobile);
		builder.append("\n email=");
		builder.append(email);
		builder.append("\n ���=");
		builder.append(grade);
		builder.append("\n ������=");
		builder.append(entryDate);
		builder.append("\n ���ϸ���=");
		builder.append(mileage);
		if(manager != null) {
			builder.append("\n �����=");
			builder.append(manager);
		} else {
			builder.append("\n �����=");
			builder.append("����");
		}
		return builder.toString();
	}

	@Override // userId�� hashcode
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((entryDate == null) ? 0 : entryDate.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + mileage;
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userPw == null) ? 0 : userPw.hashCode());
		return result;
	}

	@Override // ID������ equals
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Member) {
			if(((Member)obj).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}