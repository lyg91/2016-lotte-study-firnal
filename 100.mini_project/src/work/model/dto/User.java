package work.model.dto;
import java.io.Serializable;

public class User implements Serializable{
	private String uId;
	private String uPw;
	private String uName;
	private String uMobile;
	private String uEmail;
	private String uGrade;
	private String uEntryDate;
	private int uMileage;
	private String uGender;
	private int uBirthYear;
	private String uBirthMonday;
	
	public User() {}

	public User(String uId, String uPw, String uName, String uMobile, String uEmail, String uGrade, String uEntryDate,
			int uMileage, String uGender, int uBirthYear, String uBirthMonday) {
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uMobile = uMobile;
		this.uEmail = uEmail;
		this.uGrade = uGrade;
		this.uEntryDate = uEntryDate;
		this.uMileage = uMileage;
		this.uGender = uGender;
		this.uBirthYear = uBirthYear;
		this.uBirthMonday = uBirthMonday;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPw() {
		return uPw;
	}

	public void setuPw(String uPw) {
		this.uPw = uPw;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuMobile() {
		return uMobile;
	}

	public void setuMobile(String uMobile) {
		this.uMobile = uMobile;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuGrade() {
		if(uGrade.equals("A")) {
			return "관리자 등급";
		} else {
			return "일반회원 등급";
		}
	}

	public void setuGrade(String uGrade) {
		this.uGrade = uGrade;
	}

	public String getuEntryDate() {
		return uEntryDate;
	}

	public void setuEntryDate(String uEntryDate) {
		this.uEntryDate = uEntryDate;
	}

	public int getuMileage() {
		return uMileage;
	}

	public void setuMileage(int uMileage) {
		this.uMileage = uMileage;
	}

	public String getuGender() {
		if(uGender.equals("M")) {
			return "남자";
		} else { 
			return "여자";
		}
	}

	public void setuGender(String uGender) {
		this.uGender = uGender;
	}

	public int getuBirthYear() {
		return uBirthYear;
	}

	public void setuBirthYear(int uBirthYear) {
		this.uBirthYear = uBirthYear;
	}

	public String getuBirthMonday() {
		return uBirthMonday;
	}

	public void setuBirthMonday(String uBirthMonday) {
		this.uBirthMonday = uBirthMonday;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + ", uMobile=" + uMobile + ", uEmail=" + uEmail
				+ ", uGrade=" + uGrade + ", uEntryDate=" + uEntryDate + ", uMileage=" + uMileage + ", uGender="
				+ uGender + ", uBirthYear=" + uBirthYear + ", uBirthMonday=" + uBirthMonday + "]";
	}

	@Override
	public int hashCode() {
		return 1004;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (uBirthMonday == null) {
			if (other.uBirthMonday != null)
				return false;
		} else if (!uBirthMonday.equals(other.uBirthMonday))
			return false;
		if (uEmail == null) {
			if (other.uEmail != null)
				return false;
		} else if (!uEmail.equals(other.uEmail))
			return false;
		if (uEntryDate == null) {
			if (other.uEntryDate != null)
				return false;
		} else if (!uEntryDate.equals(other.uEntryDate))
			return false;
		if (uGender == null) {
			if (other.uGender != null)
				return false;
		} else if (!uGender.equals(other.uGender))
			return false;
		if (uGrade == null) {
			if (other.uGrade != null)
				return false;
		} else if (!uGrade.equals(other.uGrade))
			return false;
		if (uId == null) {
			if (other.uId != null)
				return false;
		} else if (!uId.equals(other.uId))
			return false;
		if (uMileage != other.uMileage)
			return false;
		if (uMobile == null) {
			if (other.uMobile != null)
				return false;
		} else if (!uMobile.equals(other.uMobile))
			return false;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		if (uPw == null) {
			if (other.uPw != null)
				return false;
		} else if (!uPw.equals(other.uPw))
			return false;
		return true;
	}
}
