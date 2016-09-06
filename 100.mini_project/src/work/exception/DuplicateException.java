package work.exception;

/** 레코드 중복시 발생 예외 클래스 : 등록기능 */
public class DuplicateException extends Exception {
	/** 기본 생성자 */
	public DuplicateException() {
		super("레코드 중복 예외");
	}

	/** 레코드 중복키를 아큐먼트로 받아서 예외메시지 전달 */
	public DuplicateException(String number) {
		super(number + " : 레코드 중복 예외");
	}
}