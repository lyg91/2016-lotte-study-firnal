package work.model.dto;

import java.sql.Blob;

public class Board {

	private int bNumber;
	private String bTitle;
	private int bPw;
	private String bContent;
	private String bAuthor;
	private String bDate;
	private String bFile1;
	private String bFile2;
	private String bFile3;
	private int bHit;
	private int bNotice;
	private int bRecommend1;
	private int bRecommend2;
	private int bRecommend3;
	private int bCount;
		
	public Board() { }

	public Board(int bNumber, String bTitle, int bPw, String bContent, String bAuthor, String bDate, String bFile1,
			String bFile2, String bFile3, int bHit, int bNotice, int bRecommend1, int bRecommend2, int bRecommend3,
			int bCount) {
		this.bNumber = bNumber;
		this.bTitle = bTitle;
		this.bPw = bPw;
		this.bContent = bContent;
		this.bAuthor = bAuthor;
		this.bDate = bDate;
		this.bFile1 = bFile1;
		this.bFile2 = bFile2;
		this.bFile3 = bFile3;
		this.bHit = bHit;
		this.bNotice = bNotice;
		this.bRecommend1 = bRecommend1;
		this.bRecommend2 = bRecommend2;
		this.bRecommend3 = bRecommend3;
		this.bCount = bCount;
	}

	public int getbNumber() {
		return bNumber;
	}

	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public int getbPw() {
		return bPw;
	}

	public void setbPw(int bPw) {
		this.bPw = bPw;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	public String getbDate() {
		return bDate;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}

	public String getbFile1() {
		return bFile1;
	}

	public void setbFile1(String bFile1) {
		this.bFile1 = bFile1;
	}

	public String getbFile2() {
		return bFile2;
	}

	public void setbFile2(String bFile2) {
		this.bFile2 = bFile2;
	}

	public String getbFile3() {
		return bFile3;
	}

	public void setbFile3(String bFile3) {
		this.bFile3 = bFile3;
	}

	public int getbHit() {
		return bHit;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public int getbNotice() {
		return bNotice;
	}

	public void setbNotice(int bNotice) {
		this.bNotice = bNotice;
	}

	public int getbRecommend1() {
		return bRecommend1;
	}

	public void setbRecommend1(int bRecommend1) {
		this.bRecommend1 = bRecommend1;
	}

	public int getbRecommend2() {
		return bRecommend2;
	}

	public void setbRecommend2(int bRecommend2) {
		this.bRecommend2 = bRecommend2;
	}

	public int getbRecommend3() {
		return bRecommend3;
	}

	public void setbRecommend3(int bRecommend3) {
		this.bRecommend3 = bRecommend3;
	}

	public int getbCount() {
		return bCount;
	}

	public void setbCount(int bCount) {
		this.bCount = bCount;
	}
}
