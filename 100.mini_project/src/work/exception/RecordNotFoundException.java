package work.exception;

public class RecordNotFoundException extends Exception {
	/** 기본 생성자 */
	public RecordNotFoundException() {
		super("레코드를 찾을 수 없습니다.");
	}
	
	/** */
	public RecordNotFoundException(String key) {
	}
}