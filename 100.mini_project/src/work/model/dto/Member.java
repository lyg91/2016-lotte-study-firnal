/** 패키지 선언문 */
package work.model.dto;
import java.io.Serializable;

/**
 * @author 이영걸
 * @version ver 1.0
 * @since JDK 1.4
 */
/** 회원 클래스 */
public class Member implements Serializable{
	/** 회원 ID 멤버변수 선언 및 명시적 초기화 */
	private String userId = "GUEST";

	/** 회원 PW 멤버변수 선언 */
	private String userPw;

	/** 회원 이름 멤버변수 선언 */
	private String name;

	/** 회원 번호 멤버변수 선언 */
	private String mobile;

	/** 회원 이메일 멤버변수 선언 */
	private String email;
	
	/** 회원 등급 멤버변수 선언 */
	private String grade;

	/** 회원 등록일 멤버변수 선언 */
	private String entryDate;
	
	/** 일반회원 마일리지 멤버변수 선언 */
	private int mileage;
	
	/** 우수회원 담당자 멤버변수 선언 */
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
			return "관리자";
		} else if (grade.equals("S")) {
			return "우수회원";
		} else if (grade.equals("G")){
			return "일반회원";
		} else { 
			return "기타";
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
		builder.append("\n 비밀번호=");
		builder.append(userPw);
		builder.append("\n 이름=");
		builder.append(name);
		builder.append("\n 연락처=");
		builder.append(mobile);
		builder.append("\n email=");
		builder.append(email);
		builder.append("\n 등급=");
		builder.append(grade);
		builder.append("\n 가입일=");
		builder.append(entryDate);
		builder.append("\n 마일리지=");
		builder.append(mileage);
		if(manager != null) {
			builder.append("\n 담당자=");
			builder.append(manager);
		} else {
			builder.append("\n 담당자=");
			builder.append("없음");
		}
		return builder.toString();
	}

	@Override // userId의 hashcode
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

	@Override // ID같으면 equals
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Member) {
			if(((Member)obj).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}